//We will given a string and we have to find the longest palindromic subsequence which is common in the given string.
//So we will reverse the given string and find the longest common subsequence between the given string and the reversed string.

package DP;
import java.util.*;
public class $28_LongestCommonPalindromicSubsequence {
  
  //tabulation
  public int longestCommonPalindromicSubsequence(String text1) {
    String text2=new StringBuilder(text1).reverse().toString();
    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    for(int j=0;j<=n;j++){
        dp[0][j]=0;
    }
    for(int i=0;i<=m;i++){
        dp[i][0]=0;
    }
    
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m][n];
  }
}
