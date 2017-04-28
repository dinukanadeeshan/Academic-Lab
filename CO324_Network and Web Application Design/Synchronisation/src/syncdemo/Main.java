package syncdemo;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ziyan
 */
public class Main extends Thread {
    static ArrayReplace ar; 
    static List<String> result;
    
    @Override
    public void run() {
        ar.replace("hello", "bye");
        
    }
    
public static void main(String[] args) throws InterruptedException {
        ar = new ArrayReplace(Arrays.asList(new String[]{"hello", "world", "hi"}));
        
        Thread t1 = new Main();
        t1.start();
        t1.join();
        ar.replace("world", "Sri Lanka");   
        
        ar.printResult();
    }    
}
