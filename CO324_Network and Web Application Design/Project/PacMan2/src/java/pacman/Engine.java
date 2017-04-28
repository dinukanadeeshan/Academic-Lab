/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author K. A. Dinuka Nadeeshan - dinuka.nadeeshan1993@gmail.com
 */
public class Engine {

    public  static final int NOT_READY = 0;
    public  static final int READY = 1;
    public  static final int GAME_OVER = 2;
    
    private int game_status = NOT_READY;
    private int winner = -1;
    
    private Player[] players;
    private String[] colors = {"B", "R", "G"};
    private ArrayList<Dot> dots = new ArrayList<>();
    private Random r = new Random();

    public Engine() {
        players = new Player[4];

        players[0] = new Player(1, 0, 0);
        players[1] = new Player(2, 44, 0);
        players[2] = new Player(3, 0, 44);
        players[3] = new Player(4, 44, 44);
        generateDots();
    }

    private void generateDots() {
        int count = r.nextInt(10) + 20;
        int[] xr = new int[count];
        int[] yr = new int[count];
        for (int i = 0; i < count; i++) {
            int x = r.nextInt(43) + 1;
            int y = r.nextInt(43) + 1;

            boolean found = false;
            for (int j = 0; j < count; j++) {
                if (x == xr[j] && y == yr[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {

                //dots.add("[\"" + colors[r.nextInt(3)] + "\"," + x + "," + y + " ]");
                xr[i] = x;
                yr[i] = y;

                dots.add(new Dot(colors[r.nextInt(3)], x, y));

            }
        }
    }

    public void setPlayer(Player player, int index) {
        players[index] = player;
    }

    public Player getPlayer(int index) {
        return players[index];
    }

    public int getGame_status() {
        return game_status;
    }

    
    public String getDots() {
        String str = "[";
        int size = dots.size();
        for (int i = 0; i < size; i++) {
            str += dots.get(i);
            if (i != size - 1) {
                str += ",";
            }
        }
        str += "]";
        return str;
    }

    public void setGame_status(int game_status) {
        this.game_status = game_status;
    }

    
    
    public void update(String player_no, String key) {
        Player player = players[Integer.parseInt(player_no)-1];
        player.updatePosition(Integer.parseInt(key));
        Logger.getGlobal().log(Level.INFO, "Player P{0} position updated ", player);
        
        for (int i = 0; i < dots.size(); i++) {
            Dot dot = dots.get(i);
            if (dot.x == player.posX && dot.y == player.posY) {
                switch (dot.color) {
                    case "B":
                        player.score += 4;
                        break;

                    case "G":
                        player.score += 2;
                        break;

                    case "R":
                        player.score += 1;
                        break;
                }
                dots.remove(i);
            }
        }
        
        for (Player p : players) {
            if (p.no != player.no) {
                if (p.posX == player.posX && p.posY == player.posY) {
                    player.score -= 3;
                    p.score -= 3;
                }
            }
        }
        
        if (dots.isEmpty()) {
            game_status = GAME_OVER;
            
            int max = players[0].score;
            winner = 0;
            for (int i = 1; i < 4; i++) {
                if (max < players[i].score) {
                    max = players[i].score;
                    winner = i;
                }
            }
        }
    }

    public Player getWinner() {
        if (winner == -1) {
            return null;
        }
        return players[winner];
    }
    
    

}
