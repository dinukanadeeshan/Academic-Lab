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
public class Dot {
    String color;
    int x;
    int y;

    public Dot() {
    }

    public Dot(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[\""+color+"\", "+x+","+y+"]";
    }
    
    
    
}
