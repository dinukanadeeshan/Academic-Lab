package com.company;

import java.util.Scanner;

/**
 * Created by Dinuka on 6/21/16.
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int num = input.nextInt();

        boolean isSpec = num % 15 == 0;
        boolean isBig = num > 999;

        boolean isWeird = num % 5 == 0 && num % 6 == 0 && num % 18 != 0;

//        String output = "is "+(isSpec? "special ":"not special ")+(!isBig && !isWeird?"but not scary ":"")
//                +(isBig ? "big ":"")+(isWeird?"weird ":"")+((isBig || isWeird)?(isBig && !isWeird?"but not weird.":"but not big"):"")
//                +"." ;
//        System.out.println(num+" "+output);

        System.out.print(num + " is ");
        if (isSpec) {
            System.out.print("special");
            if (isBig || isWeird) {

                if (isBig && !isWeird) {
                    System.out.print(", big and scary but not weird.");

                } else {
                    System.out.print(", weird and scary but not big.");

                }
            } else {
                System.out.print(" but not scary.");

            }
        } else {
            System.out.print("not special");
            if (isBig || isWeird) {

                if (isBig && !isWeird) {
                    System.out.print(" big and scary but not weird.");

                } else {
                    System.out.print(" weird and scary but not big.");

                }
            } else {
                System.out.print(" and not scary.");

            }
        }

    }
}
