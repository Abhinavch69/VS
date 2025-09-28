package DP;
import java.util.*;
public class $14_SubsetSumToTarget {
  
  //method 1: Recursion + Memoization
  public boolean subsetSumToK1(int n, int k, int[] arr) {
    int[][] dp = new int[n][k + 1];
    for(int[] row: dp){
      Arrays.fill(row, -1);
    }
    return helper(n - 1, k, arr, dp);
  }
  private boolean helper(int index, int target, int[] arr, int[][] dp){
    if(target == 0) return true;
    if(index == 0) return (arr[0] == target);
    if(dp[index][target] != -1) return dp[index][target] == 1;
    boolean notTake = helper(index - 1, target, arr, dp);
    boolean take = false;
    if(arr[index] <= target) take = helper(index - 1, target - arr[index], arr, dp);
    dp[index][target] = (take || notTake) ? 1 : 0;
    return take || notTake;
  }

  //method 2: Tabulation
  public boolean subsetSumToK2(int n, int k, int[] arr) {
    boolean[][] dp = new boolean[n][k + 1];
    for(int i = 0; i < n; i++) dp[i][0] = true;
    if(arr[0] <= k) dp[0][arr[0]] = true;
    for(int index = 1; index < n; index++){
      for(int target = 1; target <= k; target++){
        boolean notTake = dp[index - 1][target];
        boolean take = false;
        if(arr[index] <= target) take = dp[index - 1][target - arr[index]];
        dp[index][target] = take || notTake;
      }
    }
    return dp[n - 1][k];
  }

  //method 3: Space Optimization
  public boolean subsetSumToK3(int n, int k, int[] arr) {
    boolean[] prev = new boolean[k + 1];
    prev[0] = true;
    if(arr[0] <= k) prev[arr[0]] = true;
    for(int index = 1; index < n; index++){
      boolean[] curr = new boolean[k + 1];
      curr[0] = true;
      for(int target = 1; target <= k; target++){
        boolean notTake = prev[target];
        boolean take = false;
        if(arr[index] <= target) take = prev[target - arr[index]];
        curr[target] = take || notTake;
      }
      prev = curr;
    }
    return prev[k];
  }
}
