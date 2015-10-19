package edu.bupt.zyq.dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Created by root on 15-10-3.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n <= 2) return n> 0? n: 0;
        int res = 0, prepre = 1, pre = 2;
        for(int i = 3; i<=n; i++){
            res = pre + prepre;
            prepre = pre;
            pre = res;
        }
        return res;
    }

}
