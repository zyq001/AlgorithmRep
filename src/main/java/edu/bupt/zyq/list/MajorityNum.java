package edu.bupt.zyq.list;

/**
 * Created by root on 15-9-11.
 */
public class MajorityNum {

public int majorityElement(int[] nums) {
        if(nums == null || nums.length < 1)return -1;
        int res, pre = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == pre) count++;
            else{
                count--;
                if(count == 0) {
                    pre = nums[i];
                    count = 1;
                }
            }
        }
        return pre;
    }

}
