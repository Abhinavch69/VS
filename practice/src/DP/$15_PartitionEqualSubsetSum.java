//It is as same as Subset sum to target problem. Here we have to find whether we can partition the array into two subsets such that their sum is equal. So, if we can find a subset with sum equal to totalSum/2 then the other subset will automatically have sum equal to totalSum/2.

package DP;
import java.util.*;
public class $15_PartitionEqualSubsetSum {
  public boolean canPartition(int[] nums,int n){
    int totalSum = 0;
    for(int num: nums) totalSum += num;
    if(totalSum % 2 != 0) return false;
    int target = totalSum / 2;
    boolean[][] dp = new boolean[n][target + 1];
    for(int i = 0; i < n; i++) dp[i][0] = true;
    if(nums[0] <= target) dp[0][nums[0]] = true;
    for(int index = 1; index < n; index++){
      for(int t = 1; t <= target; t++){
        boolean notTake = dp[index - 1][t];
        boolean take = false;
        if(nums[index] <= t) take = dp[index - 1][t - nums[index]];
        dp[index][t] = take || notTake;
      }
    }
    return dp[n - 1][target];
  }
}
