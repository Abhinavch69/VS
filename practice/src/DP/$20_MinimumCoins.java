package DP;
import java.util.*;
public class $20_MinimumCoins {
  
  //method 1: Recursion + Memoization
  public int minimumCoins1(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];
    for(int[] row: dp){
      Arrays.fill(row, -1);
    }
    int ans = helper(n - 1, amount, coins, dp);
    return (ans >= (int)1e9) ? -1 : ans;
  }
  private int helper(int index, int amount, int[] coins, int[][] dp){
    if(index == 0){
      if(amount % coins[0] == 0) return amount / coins[0];
      else return (int)1e9;
    }
    if(dp[index][amount] != -1) return dp[index][amount];
    int notTake = helper(index - 1, amount, coins, dp);
    int take = Integer.MAX_VALUE;
    if(coins[index] <= amount) take = 1 + helper(index, amount - coins[index], coins, dp);
    return dp[index][amount] = Math.min(take, notTake);
  }
  //method 2: Tabulation
  public int minimumCoins2(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];
    for(int t = 0; t <= amount; t++){
      if(t % coins[0] == 0) dp[0][t] = t / coins[0];
      else dp[0][t] = (int)1e9;
    }
    for(int index = 1; index < n; index++){
      for(int t = 0; t <= amount; t++){
        int notTake = dp[index - 1][t];
        int take = Integer.MAX_VALUE;
        if(coins[index] <= t) take = 1 + dp[index][t - coins[index]];
        dp[index][t] = Math.min(take, notTake);
      }
    }
    int ans = dp[n - 1][amount];
    return (ans >= (int)1e9) ? -1 : ans;
  }
  //method 3: Space Optimization
  public int minimumCoins3(int[] coins, int amount) {
    int n = coins.length;
    int[] prev = new int[amount + 1];
    for(int t = 0; t <= amount; t++){
      if(t % coins[0] == 0) prev[t] = t / coins[0];
      else prev[t] = (int)1e9;
    }
    for(int index = 1; index < n; index++){
      int[] curr = new int[amount + 1];
      for(int t = 0; t <= amount; t++){
        int notTake = prev[t];
        int take = Integer.MAX_VALUE;
        if(coins[index] <= t) take = 1 + curr[t - coins[index]];
        curr[t] = Math.min(take, notTake);
      }
      prev = curr;
    }
    int ans = prev[amount];
    return (ans >= (int)1e9) ? -1 : ans;
  }
}
