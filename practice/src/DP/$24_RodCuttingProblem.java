package DP;
import java.util.*;
public class $24_RodCuttingProblem {
  
  //method 1: Recursion + Memoization
  public int cutRod1(int[] price, int n) {
    int[] lengths = new int[n];
    for(int i = 0; i < n; i++) lengths[i] = i + 1;
    int[][] dp = new int[n][n + 1];
    for(int[] row: dp){
      Arrays.fill(row, -1);
    }
    return helper(n - 1, n, lengths, price, dp);
  }
  private int helper(int index, int length, int[] lengths, int[] price, int[][] dp){
    if(index == 0){
      return (length / lengths[0]) * price[0];
    }
    if(dp[index][length] != -1) return dp[index][length];
    int notTake = helper(index - 1, length, lengths, price, dp);
    int take = Integer.MIN_VALUE;
    if(lengths[index] <= length) take = price[index] + helper(index, length - lengths[index], lengths, price, dp);
    return dp[index][length] = Math.max(take, notTake);
  }

  //method 2: Tabulation
  public int cutRod2(int[] price, int n) {
    int[] lengths = new int[n];
    for(int i = 0; i < n; i++) lengths[i] = i + 1;
    int[][] dp = new int[n][n + 1];
    for(int i = 0; i <= n; i++) dp[0][i] = (i / lengths[0]) * price[0];
    for(int index = 1; index < n; index++){
      for(int length = 0; length <= n; length++){
        int notTake = dp[index - 1][length];
        int take = Integer.MIN_VALUE;
        if(lengths[index] <= length) take = price[index] + dp[index][length - lengths[index]];
        dp[index][length] = Math.max(take, notTake);
      }
    }
    return dp[n - 1][n];
  }

  //2 array space Optimization
  public int cutRod3(int[] price, int n) {
    int[] lengths = new int[n];
    for(int i = 0; i < n; i++) lengths[i] = i + 1;
    int[] prev = new int[n + 1];
    for(int i = 0; i <= n; i++) prev[i] = (i / lengths[0]) * price[0];
    for(int index = 1; index < n; index++){
      int[] curr = new int[n + 1];
      for(int length = 0; length <= n; length++){
        int notTake = prev[length];
        int take = Integer.MIN_VALUE;
        if(lengths[index] <= length) take = price[index] + curr[length - lengths[index]];
        curr[length] = Math.max(take, notTake);
      }
      prev = curr;
    }
    return prev[n];
  }

  //1 array space Optimization
  public int cutRod4(int[] price, int n) {
    int[] lengths = new int[n];
    for(int i = 0; i < n; i++) lengths[i] = i + 1;
    int[] dp = new int[n + 1];
    for(int i = 0; i <= n; i++) dp[i] = (i / lengths[0]) * price[0];
    for(int index = 1; index < n; index++){
      for(int length = 0; length <= n; length++){
        int notTake = dp[length];
        int take = Integer.MIN_VALUE;
        if(lengths[index] <= length) take = price[index] + dp[length - lengths[index]];
        dp[length] = Math.max(take, notTake);
      }
    }
    return dp[n];
  }
}
