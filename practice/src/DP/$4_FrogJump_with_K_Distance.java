package DP;
import java.util.*;
public class $4_FrogJump_with_K_Distance {
  //memoization
  public int frogJump(int n, int heights[],int k) {
    int dp[] = new int[n];
    Arrays.fill(dp,-1);
    return jump(n-1,heights,dp,k);
  }
  private int jump(int n,int heights[],int dp[],int k){
    if(n==0){
      return 0;
    }
    if(dp[n]!=-1){
      return dp[n];
    }
    int min = Integer.MAX_VALUE;
    for(int j=1;j<=k;j++){
      if(n-j>=0){
        int jump = jump(n-j,heights,dp,k)+Math.abs(heights[n]-heights[n-j]);
        min = Math.min(min,jump);
      }
    }
    dp[n] = min;
    return dp[n];
  }

  //tabulation
  public int frogJump2(int n,int heights[],int k){
    int[] dp=new int[n];
    dp[0]=0;
    for(int i=1;i<n;i++){
      int min = Integer.MAX_VALUE;
      for(int j=1;j<=k;j++){
        if(i-j>=0){
          int jump = dp[i-j]+Math.abs(heights[i]-heights[i-j]);
          min = Math.min(min,jump);
        }
      }
      dp[i]=min;
    }
    return dp[n-1];
  }
}
