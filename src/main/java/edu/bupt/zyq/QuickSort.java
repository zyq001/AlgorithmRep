package edu.bupt.zyq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zangyq on 2015/8/25.
 */
public class QuickSort {

    public static int[] sort(int[] arr){
        if(arr == null || arr.length < 1) return arr;
        return sort(arr, 0, arr.length - 1);
    }

    public static int[] sort(int[] arr, int start, int end){
        if(start >= end ) return arr;
        int pivot = getPivot(arr, start, end);
        sort(arr, start, pivot - 1);
        sort(arr, pivot + 1, end);
        return arr;
    }

    public static int getPivot(int[] arr, int start, int end){
        int value = arr[start];
        while(start < end){
            while(start < end && arr[end] > value) end--;
            if(start < end) {
                arr[start] = arr[end];
                start++;
            }
            while(start < end && arr[start] <= value) start++;
            if(start < end){
                arr[end] = arr[start];
                end--;
            }
        }
        arr[start] = value;
        return start;
    }

    public static void main(String[] args){
        int[] arr = {1,9, 3, 21,3 ,43,3,3,5,7,2,33};
        System.out.println(sort(arr));
    }


}
