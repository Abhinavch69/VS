//In this ques we will find the longest palindromic subsequence from the give string and then will minus the length of the string from the length of the longest palindromic subsequence to get the minimum insertions to make the string palindrome.

package DP;
import java.util.*;
public class $29_MinimumInsertionsToMakeStringPalindrome {
  
  //tabulation
  public int minInsertions(String s) {
    String rev=new StringBuilder(s).reverse().toString();
    int m = s.length();
    int n = rev.length();
    int[][] dp = new int[m + 1][n + 1];
    for(int j=0;j<=n;j++){
        dp[0][j]=0;
    }
    for(int i=0;i<=m;i++){
        dp[i][0]=0;
    }
    
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s.charAt(i - 1) == rev.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return m-dp[m][n];
  }
}
