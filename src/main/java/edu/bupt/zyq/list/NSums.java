package edu.bupt.zyq.list;

import java.util.*;

/**
 * Created by root on 15-10-6.
 */
public class NSums {

    /**
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     * */
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]) + 1, i +1};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("not found");
    }

    /**
     * Given an array S of n integers, are there elements a, b, c in S such
     * that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        //Hashtable O(n^2) time and O(n) space
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 2) return res;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            int target = -1 * nums[i];
            for(int j = i + 1; j < nums.length; j++){
                if(set.contains(target - nums[j])){
                    List<Integer> hit = new ArrayList<Integer>();
                    hit.add(nums[i]);
                    hit.add(Math.min(target - nums[j], nums[j]));
                    hit.add(Math.max(target - nums[j], nums[j]));
                    res.add(hit);
                }
                set.add(nums[j]);
            }
            set.clear();
        }
        return res;
    }

    public List<List<Integer>> threeSum2Pointer(int[] nums) {
        //2Pointers, oN^2, o(1) space
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 2) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] > target) right--;
                else if(nums[left] + nums[right] < target) left ++;
                else{
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return res;
        return res;
    }
}
