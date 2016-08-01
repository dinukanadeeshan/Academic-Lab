package com.fawzan.de;

/**
 * Project - CO225_Lab06
 * Created by Dinuka Nadeeshan on 8/1/16.
 * dinuka.nadeeshan1993@gmail.com
 */
public class Fibonacci {
    public static int getFibonacci(int index){

        if(index <= 2){
            return 1;
        }

        return getFibonacci(index-2) + getFibonacci(index-1);
    }

    public static int[] getFibList(int n){
        int[] arr = new int[n];

        for (int i = 0,j=3; i < n; j++,i++) {
            arr[i] = getFibonacci(j);
        }

        return arr;

    }
}
