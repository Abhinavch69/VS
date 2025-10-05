//Calculate the LCS of s1 and s2.
//Number of deletions = length of s1 - length of LCS
//Number of insertions = length of s2 - length of LCS
//Total operations = insertions + deletions

package DP;
import java.util.*;
public class $30_MinimumInsertionDeletionToConvertAString {
  
  //tabulation
  public int minOperations(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    int[][] dp = new int[m + 1][n + 1];
    for(int j=0;j<=n;j++){
        dp[0][j]=0;
    }
    for(int i=0;i<=m;i++){
        dp[i][0]=0;
    }
    
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    int lcsLength=dp[m][n];
    int deletions=m-lcsLength;
    int insertions=n-lcsLength;
    return deletions+insertions;
  }
}
