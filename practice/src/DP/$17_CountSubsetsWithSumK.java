package DP;
import java.util.*;
public class $17_CountSubsetsWithSumK {
  
  //method 1: Recursion + Memoization
  public int countOfSubsets1(int n, int k, int[] arr) {
    int[][] dp = new int[n][k + 1];
    for(int[] row: dp){
      Arrays.fill(row, -1);
    }
    return helper(n - 1, k, arr, dp);
  }
  private int helper(int index, int target, int[] arr, int[][] dp){
    if(target == 0) return 1;
    if(index == 0) return (arr[0] == target) ? 1 : 0;
    if(dp[index][target] != -1) return dp[index][target];
    int notTake = helper(index - 1, target, arr, dp);
    int take = 0;
    if(arr[index] <= target) take = helper(index - 1, target - arr[index], arr, dp);
    dp[index][target] = take + notTake;
    return take + notTake;
  }

  //method 2: Tabulation
  public int countOfSubsets2(int n, int k, int[] arr) {
    int[][] dp = new int[n][k + 1];
    for(int i = 0; i < n; i++) dp[i][0] = 1;
    if(arr[0] <= k) dp[0][arr[0]] = 1;
    for(int index = 1; index < n; index++){
      for(int target = 1; target <= k; target++){
        int notTake = dp[index - 1][target];
        int take = 0;
        if(arr[index] <= target) take = dp[index - 1][target - arr[index]];
        dp[index][target] = take + notTake;
      }
    }
    return dp[n - 1][k];
  }

  //space Optimization
  public int countOfSubsets3(int n, int k, int[] arr) {
    int[] prev = new int[k + 1];
    prev[0] = 1;
    if(arr[0] <= k) prev[arr[0]] = 1;
    for(int index = 1; index < n; index++){
      int[] curr = new int[k + 1];
      curr[0] = 1;
      for(int target = 1; target <= k; target++){
        int notTake = prev[target];
        int take = 0;
        if(arr[index] <= target) take = prev[target - arr[index]];
        curr[target] = take + notTake;
      }
      prev = curr;
    }
    return prev[k];
  }
}
