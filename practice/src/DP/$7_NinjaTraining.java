//2D DP question
//https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003

package DP;
import java.util.*;
public class $7_NinjaTraining {
  

  //method 1: Recursion + Memoization
  public static int ninjaTraining(int n, int points[][]) {
    int[][] dp = new int[n][4];
    for(int[] row : dp){
      Arrays.fill(row, -1);
    }
    return helper(n-1, 3, points, dp);
  } 
  public static int helper(int day, int last, int[][] points, int[][] dp){
    if(dp[day][last] != -1) return dp[day][last];
    if(day == 0){
      int maxi = 0;
      for(int task = 0; task < 3; task++){
        if(task != last){
          maxi = Math.max(maxi, points[0][task]);
        }
      }
      return  maxi;
    }
    int maxi = 0;
    for(int task = 0; task < 3; task++){
      if(task != last){
        int point = points[day][task] + helper(day-1, task, points, dp);
        maxi = Math.max(maxi, point);
      }
    }
    return dp[day][last] = maxi;
  }

  //method 2: Tabulation
  public static int ninjaTraining2(int n, int points[][]) {
    int[][] dp = new int[n][4];
    dp[0][0] = Math.max(points[0][1], points[0][2]);
    dp[0][1] = Math.max(points[0][0], points[0][2]);
    dp[0][2] = Math.max(points[0][0], points[0][1]);
    dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
    
    for(int day = 1; day < n; day++){
      for(int last = 0; last < 4; last++){
        dp[day][last] = 0;
        for(int task = 0; task < 3; task++){
          if(task != last){
            int point = points[day][task] + dp[day-1][task];
            dp[day][last] = Math.max(dp[day][last], point);
          }
        }
      }
    }
    return dp[n-1][3];
  }

  //method 3: Space Optimization
  public static int ninjaTraining3(int n, int points[][]) {
    int[] prev = new int[4];
    prev[0] = Math.max(points[0][1], points[0][2]);
    prev[1] = Math.max(points[0][0], points[0][2]);
    prev[2] = Math.max(points[0][0], points[0][1]);
    prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
    
    for(int day = 1; day < n; day++){
      int[] curr = new int[4];
      for(int last = 0; last < 4; last++){
        curr[last] = 0;
        for(int task = 0; task < 3; task++){
          if(task != last){
            int point = points[day][task] + prev[task];
            curr[last] = Math.max(curr[last], point);
          }
        }
      }
      prev = curr;
    }
    return prev[3];
}
