package com.company;

/**
 * Created by Dinuka on 6/18/16.
 */
public class Birthday {
    public static void main(String[] args) {
        int yr = 1993;
        short month = 12;
        short day = 31;

        int total = yr + month + day;

        System.out.println("total = " + total);

        short newTotal = (short) (yr + month + day);

        short c = (short) (month - day);
    }
}
