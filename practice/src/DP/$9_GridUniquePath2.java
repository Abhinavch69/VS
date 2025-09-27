//In this question we have to find the number of unique paths from top left corner to bottom right corner in a grid with obstacles.
//We can only move either down or right at any point in time.

package DP;
import java.util.*;
public class $9_GridUniquePath2 {
  
  //method 1: Recursion + Memoization
  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];
    for(int[] row : dp){
      Arrays.fill(row, -1);
    }
    return helper(m-1, n-1, obstacleGrid, dp);
  }
  public static int helper(int i, int j, int[][] obstacleGrid, int[][] dp){
   if(i>=0 && j>=0 && obstacleGrid[i][j] == -1) return 0;
    if(i == 0 && j == 0) return 1;

    if(i < 0 || j < 0) return 0;

    if(dp[i][j] != -1) return dp[i][j];

    if(obstacleGrid[i][j] == 1) return dp[i][j] = 0;

    int up = helper(i-1, j, obstacleGrid, dp);
    int left = helper(i, j-1, obstacleGrid, dp);
    
    return dp[i][j] = up + left;
  }

  //method 2: Tabulation
  public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;

    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(i == 0 && j == 0) continue;

        if(obstacleGrid[i][j] == -1){
          dp[i][j] = 0;
          continue;
        }

        int up = 0;
        int left = 0;

        if(i > 0) up = dp[i-1][j];
        if(j > 0) left = dp[i][j-1];

        dp[i][j] = up + left;
      }
    }
    return dp[m-1][n-1];
  }
}
