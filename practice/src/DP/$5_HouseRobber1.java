package DP;
import java.util.*;
public class $5_HouseRobber1 {
  
  //memoization
  public int rob(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n];
    Arrays.fill(dp,-1);
    return helper(n-1,nums,dp);
  }
  private int helper(int n,int[] nums,int dp[]){
    if(n==0){
      return nums[0];
    }
    if(n<0){
      return 0;
    }
    if(dp[n]!=-1){
      return dp[n];
    }
    int pick = nums[n]+helper(n-2,nums,dp);
    int notPick = 0+helper(n-1,nums,dp);
    dp[n] = Math.max(pick,notPick);
    return dp[n];
  }

  //tabulation
  public int rob2(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n];
    dp[0] = nums[0];
    for(int i=1;i<n;i++){
      int pick = nums[i];
      if(i>1){
        pick+=dp[i-2];
      }
      int notPick = 0+dp[i-1];
      dp[i] = Math.max(pick,notPick);
    }
    return dp[n-1];
  }

  //space optimization
  public int rob3(int[] nums) {
    int n = nums.length;
    int prev=nums[0];
    int prev2=0;
    for(int i=1;i<n;i++){
      int pick = nums[i];
      if(i>1){
        pick+=prev2;
      }
      int notPick = 0+prev;
      int curr = Math.max(pick,notPick);
      prev2=prev;
      prev=curr;
    }
    return prev;
  }
}
