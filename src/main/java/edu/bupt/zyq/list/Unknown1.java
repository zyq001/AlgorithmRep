package edu.bupt.zyq.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zangyq on 2015/9/29.
 */
public class Unknown1 {

    static int re = 0;
    public static int sum (int n){
        int re = 0;
        do{
            re += n;
        } while(n-- > 0);
        return re;
    }
    public static int nums(int[] arr, int start, List<Integer> list){
        if(arr.length < 1) return 0;
        if(start >= arr.length) {
            re += list.size();
            return re;
        }

        if(list.size() > 0 && arr[start] == 1) {
            List<Integer> newList = new ArrayList<Integer>(arr.length - start);
            newList.add(1);
            nums(arr, start + 1, newList);
        }
        if(list.size() < 2 && arr[start] == 1) {
            list.add(arr[start]);
        }else
         if(list.size() >= 2 && arr[start] == list.get(list.size() - 1) && arr[start] != 1){
             List<Integer> newList = new ArrayList<Integer>(list.size());
             for(int t: list) newList.add(t);
             nums(arr, start+1,newList);
        }else if(list.size() >= 2 && arr[start] == list.get(list.size() - 1) + list.get(list.size() - 2)){
            list.add(arr[start]);
        }

        nums(arr, start + 1, list);

        return re;
    }

    public static void main(String[] args) {
//        System.out.println(sum(4));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
//        int re = 0;
//        for(int j = 0; j < n; j++){
//            if(arr[j] != 1) continue;
//            re++;
//            int pp = 0, p = 1;
//            List<Integer> muti = new ArrayList<Integer>(n - j);
//            for(int k = j + 1; k < n; k++){
//                if(arr[k] == pp + p){
//                    re++;
//                    pp = p;
//                    p = arr[k];
//                }else if(arr[k] == p) {
//                    re++;
//                    muti.add(re);
//                }
//            }
//            for(int i = muti.size() - 1; i >= 0; i--){
//                re += 2 * (re - muti.get(i));
//            }
//        }
        List<Integer> list = new ArrayList<Integer>(n);
        System.out.println(nums(arr, 0, list));
//        System.out.println(re);
    }

}
