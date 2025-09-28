//In this problem there are two person alice and bob. Alice is standing at top left corner and bob is standing at top right corner of a grid. Both have to reach the bottom row of the grid. Alice can only move down or down right or down left and bob can only move down or down left opr down right. If both are standing on the same cell then only one of them can pick the value of that cell. We have to find the maximum path sum both can collect.

package DP;
import java.util.*;
public class $13_3D_DP {
  
  //method 1: Recursion + Memoization
  public int cherryPickup(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][][] dp = new int[n][m][m];
    for(int[][] row: dp){
      for(int[] col: row){
        Arrays.fill(col, -1);
      }
    }
    return helper(grid, 0, 0, m - 1, dp);
  }
  private int helper(int[][] grid, int r, int c1, int c2, int[][][] dp){
    if(c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length) return (int)-1e8;
    if(r == grid.length - 1){
      if(c1 == c2) return grid[r][c1];
      else return grid[r][c1] + grid[r][c2];
    }
    if(dp[r][c1][c2] != -1) return dp[r][c1][c2];
    int maxCherries = Integer.MIN_VALUE;
    for(int moveC1 = -1; moveC1 <= 1; moveC1++){
      for(int moveC2 = -1; moveC2 <= 1; moveC2++){
        int cherries = 0;
        if(c1 == c2) cherries = grid[r][c1];
        else cherries = grid[r][c1] + grid[r][c2];
        cherries += helper(grid, r + 1, c1 + moveC1, c2 + moveC2, dp);
        maxCherries = Math.max(maxCherries, cherries);
      }
    }
    return dp[r][c1][c2] = maxCherries;
  }

  //method 2: Tabulation
  public int cherryPickup2(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][][] dp = new int[n][m][m];
    for(int c1 = 0; c1 < m; c1++){
      for(int c2 = 0; c2 < m; c2++){
        if(c1 == c2) dp[n - 1][c1][c2] = grid[n - 1][c1];
        else dp[n - 1][c1][c2] = grid[n - 1][c1] + grid[n - 1][c2];
      }
    }
    for(int r = n - 2; r >= 0; r--){
      for(int c1 = 0; c1 < m; c1++){
        for(int c2 = 0; c2 < m; c2++){
          int maxCherries = Integer.MIN_VALUE;
          for(int moveC1 = -1; moveC1 <= 1; moveC1++){
            for(int moveC2 = -1; moveC2 <= 1; moveC2++){
              int cherries = 0;
              if(c1 == c2) cherries = grid[r][c1];
              else cherries = grid[r][c1] + grid[r][c2];
              if(c1 + moveC1 >= 0 && c1 + moveC1 < m && c2 + moveC2 >= 0 && c2 + moveC2 < m){
                cherries += dp[r + 1][c1 + moveC1][c2 + moveC2];
              } else {
                cherries += (int)-1e8;
              }
              maxCherries = Math.max(maxCherries, cherries);
            }
          }
          dp[r][c1][c2] = maxCherries;
        }
      }
    }
    return dp[0][0][m - 1];
  }
}