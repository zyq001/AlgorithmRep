package edu.bupt.zyq.list;

import edu.bupt.zyq.ArrayBase;

import java.util.Arrays;

/**
 * Created by zangyq on 2015/8/25.
 */
public class HeapSort {
    //算法导论实现

    public static void heapfy(int[] arr, int index, int end){
        //向下调整，结果保证以index为根，end之前，的树构成堆
        if(arr == null || index >= end || end >= arr.length) return;
        int left = index * 2 + 1, right = index * 2 + 2, largest = index;//largest记录index与左右孩子中最大者下标，如果孩子大，则需要交换
        if(left <= end && arr[index] < arr[left]){
            largest = left;
        }
        if(right <= end && arr[largest] < arr[right]){
            largest = right;
        }

        if(largest != index){//判断是否需要调整
            ArrayBase.swap(arr, largest, index);
            heapfy(arr, largest, end);
        }
    }

    public static void buidHeap(int[] arr){
        if(arr == null || arr.length <= 1) return;
        int length = arr.length;
        for(int i = length / 2 - 1; i >= 0; i--){
            heapfy(arr, i, length - 1);
        }
    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length <= 1) return;
        buidHeap(arr);
        for(int i = arr.length - 1; i > 0; i--){
            ArrayBase.swap(arr, i, 0);
            heapfy(arr, 0, i - 1);//***一定要i - 1， 要不然会把刚才交换到后面的数又换回来
        }
    }




    public static void main(String[] args){
        int[] arr = {1, 4, 12, 11, 9, 34, 45, 30, 3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
