package edu.bupt.zyq.dp;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 * Created by root on 15-10-4.
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        //2DMatrix to 1D Array
        if(word1 == null || word2 == null) return -1;
        int m = word1.length(), n = word2.length();
        if(m == 0) return n;
        if(n == 0) return m;
        int[] arr = new int[n + 1];
        for(int j = 1; j <= n; j++) arr[j] = j;

        for(int i = 1; i <= m; i++){
            int pre = arr[0];//the valur of matrix[i - 1][j - 1]
            arr[0] = i;
            for(int j = 1; j <= n; j++){
                int carry = word1.charAt(i - 1) == word2.charAt(j - 1)?0:1;
                int tmp = arr[j];//tmply store the pre value before modified
                arr[j] = Math.min(Math.min(arr[j] + 1, arr[j - 1] + 1), pre + carry);
                pre = tmp;//the pre value before modified
            }
        }
        return arr[n];
    }

    public int minDistance1(String word1, String word2) {
        //??DP????????????????????
        if(word1 == null || word2 == null) return -1;
        int m = word1.length(), n = word2.length();
        if(m == 0) return n;
        if(n == 0) return m;
        int[][] matrix = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) matrix[i][0] = i;
        for(int j = 1; j <= n; j++) matrix[0][j] = j;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int carry = word1.charAt(i - 1) == word2.charAt(j - 1)?0:1;
                matrix[i][j] = Math.min(Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1), matrix[i - 1][j - 1] + carry);
            }
        }
        return matrix[m][n];
    }

}
