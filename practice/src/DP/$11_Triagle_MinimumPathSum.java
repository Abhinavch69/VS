//It is a type of fixed starting point and variable destination point DP

package DP;
import java.util.*;
public class $11_Triagle_MinimumPathSum {
  

  //method 1: Recursion + Memoization
  public int minimumTotal1(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] dp = new int[n][n];
    for(int[] row: dp){
      Arrays.fill(row, -1);
    }
    return helper(triangle, 0, 0, dp);
  }
  private int helper(List<List<Integer>> triangle, int r, int c, int[][] dp){
    if(r == triangle.size() - 1){
      return triangle.get(r).get(c);
    }
    if(dp[r][c] != -1) return dp[r][c];
    int down = triangle.get(r).get(c) + helper(triangle, r + 1, c, dp);
    int diag = triangle.get(r).get(c) + helper(triangle, r + 1, c + 1, dp);
    return dp[r][c] = Math.min(down, diag);
  }

  //method 2: Tabulation
  public int minimumTotal2(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] dp = new int[n][n];
    for(int j = 0; j < n; j++){
      dp[n - 1][j] = triangle.get(n - 1).get(j);
    }
    for(int r = n - 2; r >= 0; r--){
      for(int c = 0; c <= r; c++){
        int down = triangle.get(r).get(c) + dp[r + 1][c];
        int diag = triangle.get(r).get(c) + dp[r + 1][c + 1];
        dp[r][c] = Math.min(down, diag);
      }
    }
    return dp[0][0];
  }

  //method 3: Space Optimization
  public int minimumTotal3(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] front = new int[n];
    for(int j = 0; j < n; j++){
      front[j] = triangle.get(n - 1).get(j);
    }
    for(int r = n - 2; r >= 0; r--){
      int[] curr = new int[n];
      for(int c = 0; c <= r; c++){
        int down = triangle.get(r).get(c) + front[c];
        int diag = triangle.get(r).get(c) + front[c + 1];
        curr[c] = Math.min(down, diag);
      }
      front = curr;
    }
    return front[0];
  }
}
