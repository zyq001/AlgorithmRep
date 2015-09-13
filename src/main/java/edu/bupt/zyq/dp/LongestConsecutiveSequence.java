package edu.bupt.zyq.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 15-9-11.
 */
public class LongestConsecutiveSequence {
    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

     For example,
     Given [100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

     Your algorithm should run in O(n) complexity.
     * */

    public int longestConsecutive(int[] num) {
        //key?num????value??????????key?????????????
        //????????????????????????????????hashmap????
        //?????????????t?????t-1?????????t????t+1?
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        int min = 0, re = 1, i = 1, nowCount = 0;
        for(int t: num){
            if(!hashmap.containsKey(t)){//??????????t? ???
                int left = hashmap.containsKey(t - 1)? hashmap.get(t - 1): 0;
                int right = hashmap.containsKey(t + 1)? hashmap.get(t + 1): 0;
                int sum = left + right + 1;
                hashmap.put(t, sum);
                re = Math.max(re, sum);
                hashmap.put(t - left, sum);
                hashmap.put(t + right, sum);
            }
        }
        return re;
    }

}
