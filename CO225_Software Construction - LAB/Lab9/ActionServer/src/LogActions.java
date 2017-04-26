/**
 * Action Server - (Socket Programming)
 * <p>
 * CO225 - Software Construction - Lab 09
 * <p>
 * Developer : K. A. D. Nadeeshan - dinuka.nadeeshan1993@gmail.com
 * <p>
 * &#169; Unicorn Inc.(TM)
 */

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class LogActions {
    private static JTextArea textArea;

    private static DateFormat format;

    public static void setTextArea(JTextArea textArea) {
        LogActions.textArea = textArea;
        format = new SimpleDateFormat("hh:mm:ss");
    }


    public static void log(String txt) {
        textArea.append("\u00A4 - " + format.format(new Date()) + " - " + txt + "\n");
    }

}
