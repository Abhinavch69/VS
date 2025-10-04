package DP;
import java.util.*;
public class $23_UnboundedKnapsack {
  
  //method 1: Recursion + Memoization
  public int unboundedKnapsack1(int n, int w, int[] profit, int[] weight) {
    int[][] dp = new int[n][w + 1];
    for(int[] row: dp){
      Arrays.fill(row, -1);
    }
    return helper(n - 1, w, profit, weight, dp);
  }
  private int helper(int index, int w, int[] profit, int[] weight, int[][] dp){
    if(index == 0){
      return (w / weight[0]) * profit[0];
    }
    if(dp[index][w] != -1) return dp[index][w];
    int notTake = helper(index - 1, w, profit, weight, dp);
    int take = Integer.MIN_VALUE;
    if(weight[index] <= w) take = profit[index] + helper(index, w - weight[index], profit, weight, dp);
    return dp[index][w] = Math.max(take, notTake);
  }

  //method 2: Tabulation
  public int unboundedKnapsack2(int n, int w, int[] profit, int[] weight) {
    int[][] dp = new int[n][w + 1];
    for(int i = 0; i <= w; i++) dp[0][i] = (i / weight[0]) * profit[0];
    for(int index = 1; index < n; index++){
      for(int weightCap = 0; weightCap <= w; weightCap++){
        int notTake = dp[index - 1][weightCap];
        int take = Integer.MIN_VALUE;
        if(weight[index] <= weightCap) take = profit[index] + dp[index][weightCap - weight[index]];
        dp[index][weightCap] = Math.max(take, notTake);
      }
    }
    return dp[n - 1][w];
  }

  //2 array space Optimization
  public int unboundedKnapsack3(int n, int w, int[] profit, int[] weight) {
    int[] prev = new int[w + 1];
    for(int i = 0; i <= w; i++) prev[i] = (i / weight[0]) * profit[0];
    for(int index = 1; index < n; index++){
      int[] curr = new int[w + 1];
      for(int weightCap = 0; weightCap <= w; weightCap++){
        int notTake = prev[weightCap];
        int take = Integer.MIN_VALUE;
        if(weight[index] <= weightCap) take = profit[index] + curr[weightCap - weight[index]];
        curr[weightCap] = Math.max(take, notTake);
      }
      prev = curr;
    }
    return prev[w];
  }

  //1 array space Optimization
  public int unboundedKnapsack4(int n, int w, int[] profit, int[] weight) {
    int[] dp = new int[w + 1];
    for(int i = 0; i <= w; i++) dp[i] = (i / weight[0]) * profit[0];
    for(int index = 1; index < n; index++){
      for(int weightCap = 0; weightCap <= w; weightCap++){
        int notTake = dp[weightCap];
        int take = Integer.MIN_VALUE;
        if(weight[index] <= weightCap) take = profit[index] + dp[weightCap - weight[index]];
        dp[weightCap] = Math.max(take, notTake);
      }
    }
    return dp[w];
  }
}
