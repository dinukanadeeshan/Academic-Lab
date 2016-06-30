package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(love6(6, 4));
        System.out.println(love6(4, 5));
        System.out.println(love6(1, 5));
        System.out.println();
        System.out.println(in1To10(5, false));
        System.out.println(in1To10(11, false));
        System.out.println(in1To10(11, true));
        System.out.println();
        System.out.println(specialEleven(22));
        System.out.println(specialEleven(23));
        System.out.println(specialEleven(24));
        System.out.println();
        System.out.println(lastDigit(23, 19, 13));
        System.out.println(lastDigit(23, 19, 12));
        System.out.println(lastDigit(23, 19, 3));
        System.out.println();
        System.out.println(answerCell(false, false, false));
        System.out.println(answerCell(false, false, true));
        System.out.println(answerCell(true, false, false));
        System.out.println();
        System.out.println(alarmClock(1, false));
        System.out.println(alarmClock(5, false));
        System.out.println(alarmClock(0, false));
    }

    private static boolean love6(int a, int b) {
        if (a == 6 || b == 6) {
            return true;
        } else if (Math.abs(a - b) == 6 || a + b == 6) {
            return true;
        }
        return false;
    }

    private static boolean in1To10(int n, boolean outsideMode) {
        if (outsideMode)
            return !(n >= 0 && n <= 10);

        return n > 0 && n < 10;
    }

    private static boolean specialEleven(int n) {
        return (n % 11 == 0 || n % 11 == 1);

    }

    private static boolean lastDigit(int a, int b, int c) {
        return (a % 10 == b % 10 || b % 10 == c % 10 || a % 10 == c%10);
    }

    private static boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
        if (isAsleep) return false;
        if (isMom) return true;
        if (isMorning) return false;
        return true;
    }

    private static String alarmClock(int day, boolean vacation) {


        if (vacation)
            if (day == 6 || day == 0)
                return "off";
            else
                return "10:00";

        if (day == 6 || day == 0)
            return "10:00";
        return "7:00";

    }


}
