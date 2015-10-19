package edu.bupt.zyq.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Created by zangyq on 2015/10/6.
 */
public class Sum4 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if( nums == null || nums.length < 4) return res;
        int length = nums.length, l1 = 0, l2 = 1, r2 = length - 2, r1 = length - 1;
        Arrays.sort(nums);
        while(r1 > l1 + 2){
            int sum = nums[l1] + nums[l2] + nums[r2] + nums[r1];
            if(sum == target){
                List<Integer> hit = new ArrayList<Integer>();
                hit.add(nums[l1]);
                hit.add(nums[l2]);
                hit.add(nums[r2]);
                hit.add(nums[r1]);
                res.add(hit);
                //move 2 pointer
                if(l2 == r2 - 1){
                    if(nums[l1] + nums[l1 + 1] + nums[r1 - 1] + nums[r1] > target){
                        r1--;
                    }else{
                        l1++;
                    }
                    l2 = l1 + 1;
                    r2 = r1 - 1;
                }else{
                    l2++;
                }
            }else if(sum > target){
                if(l2 == r2 - 1){
                    if(nums[l1] + nums[l1 + 1] + nums[r1 - 1] + nums[r1] > target){
                        r1--;
                    }else{
                        l1++;
                    }
                    l2 = l1 + 1;
                    r2 = r1 - 1;
                }else{
                    r2 --;
                }
            }else{
                if(l2 == r2 - 1){
                    if(nums[l1] + nums[l1 + 1] + nums[r1 - 1] + nums[r1] > target){
                        r1--;
                    }else{
                        l1++;
                    }
                    l2 = l1 + 1;
                    r2 = r1 - 1;
                }else{
                    l2++;
                }
            }

        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {1, 0, -1, 0, -2, 2};
        new Sum4().fourSum(nums, 0);
    }
}
