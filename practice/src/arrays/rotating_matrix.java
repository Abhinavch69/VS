package arrays;
import java.util.*;
public class rotating_matrix {

  //rotating 90 degree clockwise
  //1. transpose the matrix(convert rows into matrix)
  //2. reverse each row
  
  public static void rotate90Clockwise(int[][] matrix){
    int n = matrix.length;

    //step 1. transpose the matrix
    for(int i=0;i<n;i++){
      for(int j=i;j<n;j++){
        //Swap matrix[i][j] with matrix[j][i]
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
      }
    }

    //step 2. reverse each row
    for(int i=0;i<n;i++){
      for(int j=0;j<n/2;j++){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[i][n-1-j];
        matrix[i][n-1-j]=temp;
      }
    }
  }

  //rotate 90 degree anticlockwise
  //1. transpose the matrix
  //2. reverse each column

  public static void rotate90counterClockwise(int[][] matrix){
    int n = matrix.length;

    //Step 1. Transpose the matrix
    for(int i=0;i<n;i++){
      for(int j=i;j<n;j++){
        //swap matrix[i][j] with matrix[j][i]
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
      }
    }

    //step 2. reverse each column
    for(int j=0;j<n;j++){
      for(int i=0, k=n-1;i<k;i++,k--){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[k][j];
        matrix[k][j]=temp;
      }
    }
  }
  public static void main(String[] args) {
    int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
    rotate90Clockwise(mat);
    for(int[] a:mat){
      System.out.println(Arrays.toString(a));
    }
    rotate90counterClockwise(mat);
    System.out.println();
    for(int[] a:mat){
      System.out.println(Arrays.toString(a));
    }
  }
}
