package DP;
import java.util.*;
public class $18_CountPartitionWithGivenDifference {
  
  //method 1: Recursion + Memoization
  public int countPartitions1(int n, int d, int[] arr) {
    int totalSum = 0;
    for(int num: arr) totalSum += num;
    if((totalSum - d) < 0 || (totalSum - d) % 2 != 0) return 0;
    int target = (totalSum - d) / 2;
    int[][] dp = new int[n][target + 1];
    for(int[] row: dp){
      Arrays.fill(row, -1);
    }
    return helper(n - 1, target, arr, dp);
  }
  private int helper(int index, int target, int[] arr, int[][] dp){
    if(target == 0) return 1;
    if(index == 0) return (arr[0] == target) ? 1 : 0;
    if(dp[index][target] != -1) return dp[index][target];
    int notTake = helper(index - 1, target, arr, dp);
    int take = 0;
    if(arr[index] <= target) take = helper(index - 1, target - arr[index], arr, dp);
    return dp[index][target] = take + notTake;
  }

  //method 2: Tabulation
  public int countPartitions2(int n, int d, int[] arr) {
    int totalSum = 0;
    for(int num: arr) totalSum += num;
    if((totalSum - d) < 0 || (totalSum - d) % 2 != 0) return 0;
    int target = (totalSum - d) / 2;
    int[][] dp = new int[n][target + 1];
    for(int i = 0; i < n; i++) dp[i][0] = 1;
    if(arr[0] <= target) dp[0][arr[0]] = 1;
    for(int index = 1; index < n; index++){
      for(int t = 1; t <= target; t++){
        int notTake = dp[index - 1][t];
        int take = 0;
        if(arr[index] <= t) take = dp[index - 1][t - arr[index]];
        dp[index][t] = take + notTake;
      }
    }
    return dp[n - 1][target];
  }
}
