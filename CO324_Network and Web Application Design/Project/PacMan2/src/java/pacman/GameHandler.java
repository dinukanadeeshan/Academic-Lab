/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "GameHandler", urlPatterns = {"/game", "/UpdateGame", "/reset"})
public class GameHandler extends HttpServlet {

    private ServletContext ctx;
    private Engine engine;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        engine = new Engine();

        ctx = getServletContext();
        ctx.setAttribute("player_count", "0");
        Logger.getGlobal().log(Level.INFO, "GameHandler servlet initialized...");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/event-stream;charset=UTF-8");

        Object obj = request.getSession().getAttribute("player");
        Logger.getGlobal().log(Level.INFO, "obj check GET ====================  {0}", obj);
        int player_count = Integer.parseInt((String) ctx.getAttribute("player_count"));
        if (player_count < 4) {
            Player player = null;
            if (obj == null) {

                switch (player_count) {
                    case 0:
                        player = engine.getPlayer(0);
                        player_count++;
                        break;

                    case 1:
                        player = engine.getPlayer(1);
                        player_count++;
                        break;

                    case 2:
                        player = engine.getPlayer(2);
                        player_count++;
                        break;
                    case 3:
                        player = engine.getPlayer(3);
                        player_count++;
                        break;
                    default:
                        break;
                }
                Logger.getGlobal().log(Level.INFO, "New player joined  P{0} : currently {1} players", new Object[]{player, player_count});
                ctx.setAttribute("player_count", player_count + "");
                request.getSession().setAttribute("player", player.no + "");
                if (player_count == 4) {
                    engine.setGame_status(Engine.READY);
                }
                synchronized (this){
                    notifyAll();
                }
            }

            PrintWriter out = response.getWriter();
            while (!Thread.interrupted()) {
                synchronized (this) {
                    String str = "{ \"DOTS\": " + engine.getDots() + ", "
                            + "\"PLAYERS\": [" + engine.getPlayer(0) + ", " + engine.getPlayer(1) + ", " + engine.getPlayer(2) + ", " + engine.getPlayer(3) + "],"
                            + "\"STATUS\": " + engine.getGame_status() + ","
                            + "\"WINNER\": " + engine.getWinner() + ","
                            + "\"PLAYER_COUNT\": "+ctx.getAttribute("player_count")+" }";
                    out.println("data: " + str);
                    out.println();
                    out.flush();
                    try {

                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //   
            }
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object obj = request.getSession().getAttribute("player");

        if (obj != null && obj instanceof String) {

            String player = (String) obj;
            String key = request.getParameter("keypress");
            Logger.getGlobal().log(Level.INFO, "Player P{0} pressed {1}", new Object[]{player, key});
            if (key != null) {
                synchronized (this) {
                    if (engine.getGame_status() == Engine.READY) {
                        engine.update(player, key);
                    }

                    notifyAll();
                    
                }
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        synchronized (this) {
            engine = new Engine();
            notifyAll();
        }
        System.gc();
        Logger.getGlobal().log(Level.INFO, "Game Reset done...");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
