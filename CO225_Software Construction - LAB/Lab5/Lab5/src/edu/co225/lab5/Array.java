
package edu.co225.lab5;


/**
 * Project - Lab 05 CO225 Software Construction
 * Created by Dinuka Nadeeshan (E/13/234) on 7/12/16.
 * dinuka.nadeeshan1993@gmail.com
 */
public class Array {
    private static final int DEFAULT_SIZE = 0; //Use for create default Array Object

    private int size;   //Current no of elements of the array

    private int[] data; //Store the data

    /**
     * Constructor - Initialize the data with default size
     */
    public Array() {
        data = new int[DEFAULT_SIZE];
    }

    /**
     * Constructor Initialize the data with n no of elements
     *
     * @param n no of elements for data
     */
    public Array(int n) {
        data = new int[n];
        size = n;
    }


    /**
     * Add new element to the Array at the end
     *
     * @param d value of element
     */
    public void add(int d) {
        try{
            data = copyOf(data, ++size);
            data[size - 1] = d;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    /**
     * Add the integer ’d’ to the given index
     *
     * @param index index of element of the array
     * @param d     value of element to be added to the array
     */
    public void add(int index, int d) {
        /*
            @REMINDER
            size ekata wada index eka loku unoth mkada krnnee??? Ask Fawsaan...

         */
//        if (size < data.length) {
//            //data = Arrays.copyOf(data, ++size);
//            for (int i = size++; i > index; i--) {
//                data[i] = data[i - 1];
//            }
//            data[index] = d;
//
//        } else {

        try {
            data = copyOf(data, ++size);
            for (int i = size - 1; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = d;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    /**
     * Replace the element in index with ’d’
     *
     * @param index index of element of the array
     * @param d     value of element to be replaced to the array
     */
    public void replace(int index, int d) {
        try {
            data[index] = d;
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            //throw new ArrayIndexOutOfBoundsException("Invalid Index : " + index);
            e.printStackTrace();
        }
    }

    /**
     * Get the element in the given index
     *
     * @param index index of element of the array
     * @return value of element of relevant Index
     */
    public int get(int index) {

        try {
            return data[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            //throw new ArrayIndexOutOfBoundsException("Invalid index - can't use negative values"); //Throws new exception for array index out of bound
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Remove the element in the given index
     *
     * @param index index of element of the array to be removed
     */
    public void remove(int index) {
        try {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[--size] = 0;
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            //throw new ArrayIndexOutOfBoundsException("Invalid index - can't use negative values"); //Throws new exception for array index out of bound
            e.printStackTrace();
        }
    }

    /**
     * Check whether the array is empty
     *
     * @return true if array is empty otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the size of the array
     *
     * @return size of the array
     */
    public int size() {
        return size;
    }


    /**
     * Check whether specific element is in the array
     *
     * @param d the value of element for check
     * @return true/false based on wether or not the element is found on  the array
     */
    public boolean contains(int d) {
        for (int i = 0; i < size; i++) {
            if (data[i] == d) return true;
        }
        return false;
    }


    /**
     * Trim the array so that only first ’size’ elements are  available in the array
     *
     * @param size for trim the array
     */
    public void trimToSize(int size) {
        data = copyOf(data, size);
        this.size = size;

    }


    private int[] copyOf(int[] ar, int new_size) {
        int temp[] = new int[new_size];

        try{for (int i = 0; i < ar.length; i++) {
            temp[i] = ar[i];
        }
        }catch (ArrayIndexOutOfBoundsException e){
            //e.printStackTrace();
        }
        return temp;
    }

    /**
     * Remove all the element from the array
     */
    public void clear() {
        trimToSize(0);
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        String desc = "[";

        for (int i = 0; i < size; i++) {
            desc += data[i] + ", ";
        }

        desc = desc.substring(0, desc.length() - 2) + "]";

        return desc;

    }
}
