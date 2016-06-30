package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        printArray(new int[5]);


        System.out.println(countEvens(new int[]{2, 1, 2, 3, 4}));
        System.out.println(countEvens(new int[]{2, 2, 0}));
        System.out.println(countEvens(new int[]{1, 3, 5}));
        System.out.println();
        System.out.println(Arrays.toString(pre4(new int[]{1, 2, 4, 1})));
        System.out.println(Arrays.toString(pre4(new int[]{3, 1, 4})));
        System.out.println(Arrays.toString(pre4(new int[]{1, 4, 4})));
        System.out.println();
        System.out.println(has12(new int[]{1, 3, 2}));
        System.out.println(has12(new int[]{3, 1, 2}));
        System.out.println(has12(new int[]{3, 1, 4, 5, 2}));
        System.out.println();
        System.out.println(Arrays.toString(withoutTen(new int[]{1, 10, 10, 2})));
        System.out.println(Arrays.toString(withoutTen(new int[]{10, 2, 10})));
        System.out.println(Arrays.toString(withoutTen(new int[]{1, 99, 10})));
        System.out.println();
        System.out.println(sum28(new int[]{2, 3, 2, 2, 4, 2}));
        System.out.println(sum28(new int[]{2, 3, 2, 2, 4, 2, 2}));
        System.out.println(sum28(new int[]{1, 2, 3, 4}));
        System.out.println();
        System.out.println(twoTwo(new int[]{4, 2, 2, 3}));
        System.out.println(twoTwo(new int[]{2, 2, 4}));
        System.out.println(twoTwo(new int[]{2, 2, 4, 2}));
        System.out.println();

    }

    private static int countEvens(int arr[]){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                count++;

        }

        return count;
    }

    private static int[] pre4(int arr[]){
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4){
                n = i;
                break;
            }

        }

        int newArr[] = new int[n];

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        return  newArr;
    }

    private static boolean has12(int arr[]){
        boolean is1 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                is1 = true;

            }
            if (arr[i] == 2 && is1){
                return true;
            }
        }
        return false;

    }

    private static int[] withoutTen(int arr[]){
        int newArr[] = new int[arr.length];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != 10){
                newArr[j] = arr[i];
                j++;
            }
        }
        return newArr;
    }

    private static boolean sum28(int arr[]){
        int count=0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2)
                count++;

            if (count > 4)
                break;
        }

        return count == 4 ? true : false;

    }

    private static boolean twoTwo(int arr[]){
        boolean isOk = false;
        if (arr[arr.length-1] == 2){
            if( arr[arr.length - 2] != 2)
                return false;
        }

        for (int i = 0; i < arr.length-1; i++) {


            if (arr[i] == 2){
                isOk = arr[i+1] == 2;
                i++;
            }

        }
        return isOk;
       // System.out.println(Arrays.toString(arr));

    }

    public static void printArray(int array[]){

        String ar = "{";
        
        for(int i: array){
            ar += i + " ";
        }
        ar = ar.substring(0,ar.length() - 1) + "}";
        System.out.println(ar);
    }

}
