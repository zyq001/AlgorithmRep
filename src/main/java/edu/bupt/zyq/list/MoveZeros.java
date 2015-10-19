package edu.bupt.zyq.list;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 *
 * Created by root on 15-10-2.
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int left = 0, right = 0, length = nums.length;
        for(int i = 0, j = 0; i < length; ++i){
            if(nums[i] != 0) swap(nums, i, j++);
        }
    }
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
