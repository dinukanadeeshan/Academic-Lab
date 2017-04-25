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
public class Player {

    int no;
    int posX;
    int posY;
    int score;

    public Player(int no, int posX, int posY) {
        this.no = no;
        this.posX = posX;
        this.posY = posY;
    }

    public void updatePosition(int key) {
        switch (key) {
            case 37:
                if (posX > 0) {
                    posX--;
                }
                break;
            case 38:
                if (posY > 0) {
                    posY--;
                }
                break;
            case 39:
                if (posX < 44) {
                    posX++;
                }
                break;
            case 40:
                if (posY < 44) {
                    posY++;
                }
                break;
            default:
            //throw new AssertionError();
        }
    }

    
     @Override
    public String toString() {
        return "[ \"P"+no+"\","+score+" , "+posX+" , "+posY+"]";
    }
    
}
