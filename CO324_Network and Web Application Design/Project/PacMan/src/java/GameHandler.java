/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/game","/UpdateGame"})
public class GameHandler extends HttpServlet {
    private ServletContext ctx;
    

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
        ctx = getServletContext();
        ctx.setAttribute("player_count", "0");
    }

    
    
   
    
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
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        
        Object obj = request.getSession().getAttribute("player");
        if (obj == null) {
            int player_count = Integer.parseInt((String) ctx.getAttribute("player_count"));
            if (player_count < 4) {
                obj = ++player_count + "";
                ctx.setAttribute("player_count", player_count+"");
            }
            request.getSession().setAttribute("player", String.valueOf(obj));
        }
        
        int player = Integer.parseInt((String) obj);
        String str = "{ \"DOTS\": [ [\"B\", 5, 6], [\"G\", 23, 12], [\"R\", 34, 7], [\"B\", 25, 8], [\"G\", 28, 1], [\"R\", 42, 17],  [\"B\", 15, 36], [\"G\", 22, 22], [\"R\", 5, 37], [\"B\", 25, 28], [\"G\", 9, 39], [\"R\", 10, 21]  ], \"PLAYERS\": [[\"P1\", 8, 0, 1], [\"P2\", 5, 44, 0], [\"P3\", -6, 0, 44], [\"P4\", 10, 44, 44]] }";
        out.println("data: " + str);
        out.println();
        out.flush();
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
        response.setContentType("text/event-stream;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        
        
       // System.out.println("key pressed "+request.getParameter("keypress"));
        Logger.getGlobal().log(Level.INFO, "key pressed "+request.getParameter("keypress"));
        
        Object obj = request.getSession().getAttribute("player");
        if (obj == null) {
            int player_count = Integer.parseInt((String) ctx.getAttribute("player_count"));
            if (player_count < 4) {
                obj = ++player_count + "";
                ctx.setAttribute("player_count", player_count+"");
            }
            request.getSession().setAttribute("player", String.valueOf(obj));
        }
        
        int player = Integer.parseInt((String) obj);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
