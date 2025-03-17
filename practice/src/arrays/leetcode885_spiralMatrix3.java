package arrays;
import java.util.*;
public class leetcode885_spiralMatrix3 {

  static public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart){
    int directions[][]={{0,1},{1,0},{0,-1},{-1,0}};
    int n=rows*cols;
    int res[][]=new int[n][2];
    res[0][0]=rStart;
    res[0][1]=cStart;
    int count=1;
    int step=1;
    int index=0;
    while(count<n){
      for(int times=0;times<2;times++){
        int dr=directions[index%4][0];
        int dc=directions[index%4][1];
        for(int i=0;i<step;i++){
          rStart+=dr;
          cStart+=dc;
          if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
            res[count][0]=rStart;
            res[count][1]=cStart;
            count++;
          }
        }
        index++;
      }
      step++;
    }
    return res;
  }
  public static void main(String[] args) {
    int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
    int[][] res=new int[9][2];
    res=spiralMatrixIII(3, 3, 1, 2);
    for(int[] a:res){
      System.out.println(Arrays.toString(a));
    }
  }
}
