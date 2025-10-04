package DP;
import java.util.*;
public class $19_0n1Knapsack {
  
  //method 1: Recursion + Memoization
  public int knapsack1(int n, int w, int[] val, int[] wt) {
    int[][] dp = new int[n][w + 1];
    for(int[] row: dp){
      Arrays.fill(row, -1);
    }
    return helper(n - 1, w, val, wt, dp);
  }
  private int helper(int index, int w, int[] val, int[] wt, int[][] dp){
    if(index == 0){
      if(wt[0] <= w) return val[0];
      else return 0;
    }
    if(dp[index][w] != -1) return dp[index][w];
    int notTake = helper(index - 1, w, val, wt, dp);
    int take = Integer.MIN_VALUE;
    if(wt[index] <= w) take = val[index] + helper(index - 1, w - wt[index], val, wt, dp);
    return dp[index][w] = Math.max(take, notTake);
  }

  //method 2: Tabulation
  public int knapsack2(int n, int w, int[] val, int[] wt) {
    int[][] dp = new int[n][w + 1];
    for(int i = wt[0]; i <= w; i++) dp[0][i] = val[0];
    for(int index = 1; index < n; index++){
      for(int weight = 0; weight <= w; weight++){
        int notTake = dp[index - 1][weight];
        int take = Integer.MIN_VALUE;
        if(wt[index] <= weight) take = val[index] + dp[index - 1][weight - wt[index]];
        dp[index][weight] = Math.max(take, notTake);
      }
    }
    return dp[n - 1][w];
  }

  //method 3: Space Optimization
  public int knapsack3(int n, int w, int[] val, int[] wt) {
    int[] prev = new int[w + 1];
    for(int i = wt[0]; i <= w; i++) prev[i] = val[0];
    for(int index = 1; index < n; index++){
      int[] curr = new int[w + 1];
      for(int weight = 0; weight <= w; weight++){
        int notTake = prev[weight];
        int take = Integer.MIN_VALUE;
        if(wt[index] <= weight) take = val[index] + prev[weight - wt[index]];
        curr[weight] = Math.max(take, notTake);
      }
      prev = curr;
    }
    return prev[w];
  }
}
