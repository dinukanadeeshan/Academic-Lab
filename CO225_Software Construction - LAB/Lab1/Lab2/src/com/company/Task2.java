package com.company;

import java.util.Scanner;

/**
 * Created by Dinuka on 6/21/16.
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the color: ");
        int r = input.nextInt();
        int g = input.nextInt();
        int b = input.nextInt();

        int rc = 255 -r;
        int gc = 255 -g;
        int bc = 255 -b;


        if (Math.abs(rc - r) <= 32){
            rc = r >= 128 ? r - 128 : r + 128;
        }
        if (Math.abs(gc - g) <= 32){
            gc = g >= 128 ? g - 128 : g + 128;
        }
        if (Math.abs(bc - b) <= 32){
            bc = b >= 128 ? b - 128 : b + 128;
        }

        System.out.printf("The complement: %d %d %d\n",rc,gc,bc);

    }
}
