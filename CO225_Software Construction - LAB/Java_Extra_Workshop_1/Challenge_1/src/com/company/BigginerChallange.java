package com.company;


/**
 * Created by Dinuka on 6/18/16.
 */
public class BigginerChallange {
    public static void main(String[] args) {
        System.out.println(sleepIn(false, false) );
        System.out.println(sleepIn(true, false));
        System.out.println(sleepIn(false, true));
        System.out.println();
        System.out.println(monkeyTrouble(true, true));
        System.out.println(monkeyTrouble(false, false));
        System.out.println(monkeyTrouble(true, false) );
        System.out.println();
        System.out.println(sumDouble(1, 2));
        System.out.println(sumDouble(3, 2));
        System.out.println(sumDouble(2, 2));
        System.out.println();
        System.out.println(diff21(19));
        System.out.println(diff21(10));
        System.out.println(diff21(21));
        System.out.println();
        System.out.println(parrotTrouble(true, 6)  );
        System.out.println(parrotTrouble(true, 7));
        System.out.println(parrotTrouble(false, 6));
        System.out.println();
        System.out.println(lastDigit(7, 17));
        System.out.println(lastDigit(6, 17));
        System.out.println(lastDigit(3, 113));
    }

    public static boolean sleepIn(boolean weekday , boolean vacation){
       if (weekday)
           return vacation;
       else
           return true;
    }

    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile){
        return !(aSmile ^ bSmile);
    }

    public static int sumDouble(int a, int b){
        if (a == b)
            return 2*(a+b);

        return a+b;
    }

    public static int diff21(int n){
        if (n > 21)
            return 2* Math.abs(n - 21);

        return Math.abs(n - 21);
    }

    public static boolean parrotTrouble(boolean talking, int hour){
        if (talking)
            if (hour < 20 && hour >= 7)
                return false;
            else
                return true;

        return false;
    }

    public static boolean lastDigit(int a, int b){
        return a % 10 == b % 10;
    }
}
