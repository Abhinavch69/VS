package DP;
import java.util.*;
public class $8_GridUniquePaths {

  //memoization
  public static int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for(int[] row : dp){
      Arrays.fill(row, -1);
    }

    return helper(m-1, n-1, dp);
  }
  public static int helper(int i, int j, int[][] dp){
    if(i == 0 && j == 0) return 1;

    if(i < 0 || j < 0) return 0;

    if(dp[i][j] != -1) return dp[i][j];

    int up = helper(i-1, j, dp);
    int left = helper(i, j-1, dp);
    
    return dp[i][j] = up + left;
  }

  //tabulation
  public static int uniquePaths2(int m, int n) {
    int[][] dp = new int[m][n];
    dp[0][0] = 1;

    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(i == 0 && j == 0) continue;

        int up = 0;
        int left = 0;

        if(i > 0) up = dp[i-1][j];
        if(j > 0) left = dp[i][j-1];

        dp[i][j] = up + left;
      }
    }
    return dp[m-1][n-1];
  }

  //space optimization
  public static int uniquePaths3(int m, int n) {
    int[] prev = new int[n];

    for(int i = 0; i < m; i++){
      int[] curr = new int[n];
      for(int j = 0; j < n; j++){
        if(i == 0 && j == 0){
          curr[j] = 1;
          continue;
        }

        int up = 0;
        int left = 0;

        if(i > 0) up = prev[j];
        if(j > 0) left = curr[j-1];

        curr[j] = up + left;
      }
      prev = curr;
    }
    return prev[n-1];
  }
}
