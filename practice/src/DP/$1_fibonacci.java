package DP;
import java.util.*;
public class $1_fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fib(n,dp));
    }

    //memoization
    public static int fib(int n,int dp[]){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = fib(n-1,dp)+fib(n-2,dp);
        return dp[n];
    }

    //tabulation
    public static int fib2(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //In O(1) space
    public static int fib3(int n){
        if(n<=1){
            return n;
        }
        int prev2 = 0;
        int prev = 1;
        for(int i=2;i<=n;i++){
            int curr = prev2+prev;
            prev2=prev;
            prev=curr;  
        }
        return prev;
    }
}
