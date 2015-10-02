package edu.bupt.zyq.dp;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 * Created by root on 15-10-2.
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length < 1) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        return minPathSum(grid, dp, m - 1, n - 1);

    }

    public int minPathSum(int[][] grid, int[][] dp, int m, int n){
        if(m == 0 && n == 0) return grid[0][0];
        int min = Integer.MAX_VALUE;
        if(m > 0){
            if(dp[m - 1][n] < 1) dp[m - 1][n] = minPathSum(grid, dp, m - 1, n);
            min = Math.min(min, dp[m - 1][n]);
        }
        if(n > 0){
            if(dp[m][n - 1] < 1) dp[m][n - 1] = minPathSum(grid, dp, m, n - 1);
            min = Math.min(min, dp[m][n - 1]);
        }
        return min + grid[m][n];
    }

}
