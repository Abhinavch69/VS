//gotta calculate the number of ways to make a certain amount with given denominations of coins

package DP;
import java.util.*;
public class $22_CoinChange2 {
  
  //method 1: Recursion + Memoization
  public int change1(int amount, int[] coins) {
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];
    for(int[] row: dp){
      Arrays.fill(row, -1);
    }
    return helper(n - 1, amount, coins, dp);
  }
  private int helper(int index, int amount, int[] coins, int[][] dp){
    if(index == 0){
      if(amount % coins[0] == 0) return 1;
      else return 0;
    }
    if(dp[index][amount] != -1) return dp[index][amount];
    int notTake = helper(index - 1, amount, coins, dp);
    int take = 0;
    if(coins[index] <= amount) take = helper(index, amount - coins[index], coins, dp);
    return dp[index][amount] = take + notTake;
  }
  //method 2: Tabulation
  public int change2(int amount, int[] coins) {
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];
    for(int t = 0; t <= amount; t++){
      if(t % coins[0] == 0) dp[0][t] = 1;
      else dp[0][t] = 0;
    }
    for(int index = 1; index < n; index++){
      for(int t = 0; t <= amount; t++){
        int notTake = dp[index - 1][t];
        int take = 0;
        if(coins[index] <= t) take = dp[index][t - coins[index]];
        dp[index][t] = take + notTake;
      }
    }
    return dp[n - 1][amount];
  }
  //method 3: Space Optimization
  public int change3(int amount, int[] coins) {
    int n = coins.length;
    int[] prev = new int[amount + 1];
    for(int t = 0; t <= amount; t++){
      if(t % coins[0] == 0) prev[t] = 1;
      else prev[t] = 0;
    }
    for(int index = 1; index < n; index++){
      int[] curr = new int[amount + 1];
      for(int t = 0; t <= amount; t++){
        int notTake = prev[t];
        int take = 0;
        if(coins[index] <= t) take = curr[t - coins[index]];
        curr[t] = take + notTake;
      }
      prev = curr;
    }
    return prev[amount];
  }
}
