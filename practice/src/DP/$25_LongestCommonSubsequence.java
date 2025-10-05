//Shifting of Indexes
//1 will be treated as 0 , 2 will be treated as one and so on
//So we will create a dp array of size (m+1)*(n+1)

package DP;
import java.util.*;
public class $25_LongestCommonSubsequence {
  
  //recursion
  public int longestCommonSubsequence(String text1, String text2) {
    return helper(text1, text2, text1.length() - 1, text2.length() - 1);
  }
  private int helper(String text1, String text2, int i, int j) {
    if (i < 0 || j < 0) return 0;
    if (text1.charAt(i) == text2.charAt(j)) {
      return 1 + helper(text1, text2, i - 1, j - 1);
    } else {
      return Math.max(helper(text1, text2, i - 1, j), helper(text1, text2, i, j - 1));
    }
  }

  //memoization
  public int longestCommonSubsequence1(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return helper1(text1, text2, m , n , dp);
  }
  private int helper1(String text1, String text2, int i, int j, int[][] dp) {
    if (i == 0 || j == 0) return 0;
    if (dp[i ][j ] != -1) return dp[i][j];
    if (text1.charAt(i-1) == text2.charAt(j-1)) {
      return dp[i ][j ] = 1 + helper1(text1, text2, i - 1, j - 1, dp);
    }
    return dp[i ][j ] = Math.max(helper1(text1, text2, i - 1, j, dp), helper1(text1, text2, i, j - 1, dp));
    
  }

  //tabulation
  public int longestCommonSubsequence2(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    for(int j=0;i<=n;j++){
        dp[0][j]=0;
    }
    for(int i=0;j<=m;i++){
        dp[i][0]=0;
    }
    int[][] dp = new int[m + 1][n + 1];
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

  //space optimization
  public int longestCommonSubsequence3(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[] prev = new int[n + 1];
    int[] curr = new int[n + 1];
    for(int j=0;j<=n;j++){
        prev[j]=0;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          curr[j] = 1 + prev[j - 1];
        } else {
          curr[j] = Math.max(prev[j], curr[j - 1]);
        }
      }
      prev = curr;
    }
    return prev[n];
  }
}
