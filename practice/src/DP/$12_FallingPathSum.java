//It is a type of variable starting point and variable destination point DP
//We can start from any cell in the first row and reach any cell in the last row and have to calculate ther maximum path sum

package DP;
import java.util.*;
public class $12_FallingPathSum {
  
  //method 1: Recursion + Memoization
  public int maxFallingPathSum1(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] dp = new int[n][m];
    for(int[] row: dp){
      Arrays.fill(row, -1);
    }
    int maxSum = Integer.MIN_VALUE;
    for(int j = 0; j < m; j++){
      maxSum = Math.max(maxSum, helper(matrix, n-1, j, dp));
    }
    return maxSum;
  }
  private int helper(int[][] matrix, int r, int c, int[][] dp){
    if(c < 0 || c >= matrix[0].length) return (int)-1e8;
    if(r == 0){
      return matrix[r][c];
    }
    if(dp[r][c] != -1) return dp[r][c];
    int up = matrix[r][c] + helper(matrix, r -1, c, dp);
    int leftDiagonal = matrix[r][c] + helper(matrix, r - 1, c - 1, dp);
    int rightDiagonal = matrix[r][c] + helper(matrix, r - 1, c + 1, dp);
    return dp[r][c] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
  }

  //method 2: Tabulation
  public int maxFallingPathSum2(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] dp = new int[n][m];
    for(int j = 0; j < m; j++){
      dp[0][j] = matrix[0][j];
    }
    for(int i = 1; i < n; i++){
      for(int j = 0; j < m; j++){
        int up = matrix[i][j] + dp[i - 1][j];

        int leftDiagonal = matrix[i][j];
        if(j - 1 >= 0) leftDiagonal += dp[i - 1][j - 1];
        else leftDiagonal += (int)-1e8;

        int rightDiagonal = matrix[i][j];
        if(j + 1 < m) rightDiagonal += dp[i - 1][j + 1];
        else rightDiagonal += (int)-1e8;
      
        dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
      }
    }
    int maxSum = Integer.MIN_VALUE;
    for(int j = 0; j < m; j++){
      maxSum = Math.max(maxSum, dp[n - 1][j]);
    }
    return maxSum;
  }

  //method 3: Space Optimization
  public int maxFallingPathSum3(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[] prev = new int[m];
    for(int j = 0; j < m; j++){
      prev[j] = matrix[0][j];
    }
    for(int i = 1; i < n; i++){
      int[] curr = new int[m];
      for(int j = 0; j < m; j++){
        int up = matrix[i][j] + prev[j];

        int leftDiagonal = matrix[i][j];
        if(j - 1 >= 0) leftDiagonal += prev[j - 1];
        else leftDiagonal += (int)-1e8;

        int rightDiagonal = matrix[i][j];
        if(j + 1 < m) rightDiagonal += prev[j + 1];
        else rightDiagonal += (int)-1e8;
      
        curr[j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
      }
      prev = curr;
    }
    int maxSum = Integer.MIN_VALUE;
    for(int j = 0; j < m; j++){
      maxSum = Math.max(maxSum, prev[j]);
    }
    return maxSum;
  }
}
