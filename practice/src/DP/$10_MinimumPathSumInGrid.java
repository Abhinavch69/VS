package DP;
import java.util.*;
public class $10_MinimumPathSumInGrid {
  
  //method 1: Recursion + Memoization
  public static int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    for(int[] row : dp){
      Arrays.fill(row, -1);
    }
    return helper(m-1, n-1, grid, dp);
  }
  public static int helper(int i, int j, int[][] grid, int[][] dp){
    if(i == 0 && j == 0) return grid[0][0];

    if(i < 0 || j < 0) return (int)1e9;

    if(dp[i][j] != -1) return dp[i][j];

    int up = grid[i][j] + helper(i-1, j, grid, dp);
    int left = grid[i][j] + helper(i, j-1, grid, dp);
    
    return dp[i][j] = Math.min(up, left);
  }

  //method 2: Tabulation
  public static int minPathSum2(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];

    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(i == 0 && j == 0) continue;

        int up = (int)1e9;
        int left = (int)1e9;

        if(i > 0) up = grid[i][j] + dp[i-1][j];
        if(j > 0) left = grid[i][j] + dp[i][j-1];

        dp[i][j] = Math.min(up, left);
      }
    }
    return dp[m-1][n-1];
  }
}
