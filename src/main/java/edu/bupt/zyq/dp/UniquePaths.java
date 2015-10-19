package edu.bupt.zyq.dp;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 * Created by root on 15-10-3.
 */
public class UniquePaths {


    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        if(m == 1 || n == 1) return 1;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;//only used by dp[1][1]
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }


    /**
     * Follow up for "Unique Paths":

     Now consider if some obstacles are added to the grids. How many unique paths would there be?

     An obstacle and empty space is marked as 1 and 0 respectively in the grid
     * */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length < 1) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;//only used by dp[1][1]
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(obstacleGrid[i - 1][j - 1] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

}
