package edu.bupt.zyq.list;

import edu.bupt.zyq.ArrayBase;

import java.util.Arrays;

/**
 * Created by zangyq on 2015/8/25.
 */
public class HeapSort {
    //�㷨����ʵ��

    public static void heapfy(int[] arr, int index, int end){
        //���µ����������֤��indexΪ����end֮ǰ���������ɶ�
        if(arr == null || index >= end || end >= arr.length) return;
        int left = index * 2 + 1, right = index * 2 + 2, largest = index;//largest��¼index�����Һ�����������±꣬������Ӵ�����Ҫ����
        if(left <= end && arr[index] < arr[left]){
            largest = left;
        }
        if(right <= end && arr[largest] < arr[right]){
            largest = right;
        }

        if(largest != index){//�ж��Ƿ���Ҫ����
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
            heapfy(arr, 0, i - 1);//***һ��Ҫi - 1�� Ҫ��Ȼ��ѸղŽ�������������ֻ�����
        }
    }




    public static void main(String[] args){
        int[] arr = {1, 4, 12, 11, 9, 34, 45, 30, 3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
