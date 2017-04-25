/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author K. A. Dinuka Nadeeshan - dinuka.nadeeshan1993@gmail.com
 */
public class Engine {

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
    
    public String getDots(){
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
}
