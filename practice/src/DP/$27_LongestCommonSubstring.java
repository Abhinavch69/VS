package DP;
import java.util.*;
public class $27_LongestCommonSubstring {
  
  //tabulation
  public int longestCommonSubstring(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    for(int j=0;j<=n;j++){
        dp[0][j]=0;
    }
    for(int i=0;i<=m;i++){
        dp[i][0]=0;
    }
    int maxLen=0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          maxLen=Math.max(maxLen,dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }
    return maxLen;
  }

  //space optimization
  public int longestCommonSubstring2(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[] prev = new int[n + 1];
    int[] curr = new int[n + 1];
    for(int j=0;j<=n;j++){
        prev[j]=0;
    }
    int maxLen=0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          curr[j] = 1 + prev[j - 1];
          maxLen=Math.max(maxLen,curr[j]);
        } else {
          curr[j] = 0;
        }
      }
      prev = curr;
    }
    return maxLen;
  }
}
