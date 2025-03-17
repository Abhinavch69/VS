package arrays;
import java.util.*;
public class twodimensionalarray {//array of arrays
  public static void main(String[] args) {

    Scanner sc=new Scanner(System.in);
    //adding number of rows is mandatory but not columns
    //bcz size of individual arrays does not matter
    int[][] arr=new int[3][];

    int[][] arr2=new int[3][4];
    System.out.println(arr2.length); //gives us the number of rows
    //input
    for(int row=0;row<arr.length;row++){
      //now we take every row at each index
      for(int col=0;col<arr[row].length;col++){
        arr2[row][col]=sc.nextInt();
      }
    }
  }
}
