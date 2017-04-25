/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

/**
 *
 * @author K. A. Dinuka Nadeeshan - dinuka.nadeeshan1993@gmail.com
 */
public class Engine {
     private Player[] players;

    public Engine() {
        players = new Player[4];
        
        players[0] = new Player(1, 0, 0);
        players[1] = new Player(2, 44, 0);
        players[2] = new Player(3, 0, 44);
        players[3] = new Player(4, 44, 44);
        
    }
    
    public void setPlayer(Player player, int index){
        players[index] = player;
    }
     
    public Player getPlayer(int index){
        return players[index];
    }
}
