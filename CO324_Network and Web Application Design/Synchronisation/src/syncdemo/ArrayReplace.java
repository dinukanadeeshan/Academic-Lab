package syncdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ziyan
 */
public class ArrayReplace {

    List<String> words;

    public ArrayReplace( List<String> words) {
        this.words = words;
    }

    void replace(String match, String replace) {
        ArrayList<String> result = new ArrayList<>();

        for (String w : words) {
        synchronized (words) {
                if (w.equals(match)) {
                result.add(replace);
            } else {
                result.add(w);
            }
        }
        }
        
        synchronized (words) {
        words = result;
        }
    }
/*
    void printResult() {
        synchronized (words) {
        for (String w : words) {
            System.out.print(w);
        }
        }
    }
*/

    void printResult() {
        for (String word : words) {
            System.out.print(word + "\t");
        }
    }
    
}
