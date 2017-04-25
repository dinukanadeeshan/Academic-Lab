
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author K. A. Dinuka Nadeeshan - dinuka.nadeeshan1993@gmail.com
 */
public class Player extends Thread {

    int no;
    int posX;
    int posY;
    int currentKey;
    int score;

    public Player(int no, int posX, int posY) {

        this.no = no;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {

            synchronized (this) {
                try {
                    wait();
                    switch (currentKey) {
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
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "[ \"P"+no+"\","+score+" , "+posX+" , "+posY+"]";
    }
    
    

}
