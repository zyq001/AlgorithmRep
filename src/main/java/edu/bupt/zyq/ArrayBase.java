package edu.bupt.zyq;

/**
 * Created by zangyq on 2015/9/4.
 */
public class ArrayBase {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
