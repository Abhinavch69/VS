//It is same as question 5 but here houses are arranged in a circle
//So we can not rob first and last house together
//We will calculate best answer by firstexcluding first house and then excluding last house
//Then we will return max of both the answers

package DP;
import java.util.*;
public class $6_HouseRobber2 {
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

  public int rob(int[] nums) {
    int n = nums.length;
    if(n==1){
      return nums[0];
    }
    int[] arr1 = new int[n-1];
    int[] arr2 = new int[n-1];
    for(int i=0;i<n-1;i++){
      arr1[i] = nums[i];
    }
    for(int i=1;i<n;i++){
      arr2[i-1] = nums[i];
    }
    return Math.max(rob2(arr1),rob2(arr2));
  }
}
