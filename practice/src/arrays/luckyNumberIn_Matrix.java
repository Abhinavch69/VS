package arrays;
import java.util.*;
public class luckyNumberIn_Matrix {

  static public List<Integer> luckyNumbers(int[][] arr){
    int n=arr.length;
    int m=arr[0].length;
    int rMinMax=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
      int rMin=Integer.MAX_VALUE;
      for(int j=0;j<m;j++){
        rMin=Math.min(rMin,arr[i][j]);
      }
      rMinMax=Math.max(rMin,rMinMax);
    }

    int cMinMax=Integer.MAX_VALUE;
    for(int i=0;i<m;i++){
      int cMax=Integer.MIN_VALUE;
      for(int j=0;j<n;j++){
        cMax=Math.max(cMax,arr[j][i]);
      }
      cMinMax=Math.min(cMax,cMinMax);
    }

    if(cMinMax==rMinMax){
      return new ArrayList<>(Arrays.asList(rMinMax));
    }
    return new ArrayList<>();
  }
  public static void main(String[] args) {
    int[][] arr={{3,7,8},{9,11,13},{15,16,17}};
    System.out.println(luckyNumbers(arr));
  }
}