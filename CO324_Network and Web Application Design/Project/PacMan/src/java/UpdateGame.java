
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
public class UpdateGame extends Thread {

    String str;
    
    @Override
    public void run() {
        while(!Thread.interrupted()){
            synchronized (this){
                try {
                    wait();
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(UpdateGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    

}
