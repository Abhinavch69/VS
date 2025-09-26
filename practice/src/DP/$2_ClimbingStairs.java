package DP;

public class $2_ClimbingStairs {
   //memoization
   public int climbStairs(int n) {
        int dp[] = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        return climb(n,dp);
    }

    public int climb(int n,int dp[]){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = climb(n-1,dp)+climb(n-2,dp);
        return dp[n];
    }

    //tabulation
    public int climb2(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }

    //In O(1) space
    public int climb3(int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        int prev2 = 1;
        int prev = 1;
        for(int i=2;i<=n;i++){
            int curr = prev2+prev;
            prev2=prev;
            prev=curr;  
        }
        return prev;
    }
}
