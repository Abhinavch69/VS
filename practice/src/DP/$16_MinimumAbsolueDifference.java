//we use subset sum solution in this problem. So from the last row of the dp table we will find all the possible subset sums. Then we will find the minimum absolute difference between totalSum - 2*subsetSum for all the possible subset sums.

package DP;
import java.util.*;
public class $16_MinimumAbsolueDifference {
  
  int minimumSumDifference(int arr[], int n){
    int totSum=0;
    for(int num: arr) totSum+=num;
    int k=totSum;
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

    int mini=(Integer.MAX_VALUE);
    for(int s1=0;s1<=totSum/2;s1++){
      if(dp[n-1][s1]==true){
        mini=Math.min(mini,Math.abs(totSum-2*s1));
      }
    }

    return mini;
  }
}
