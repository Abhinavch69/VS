//Sorting 2D array on the basis of first element of each row
//time complexity = O(n log n)

package arrays;
import java.util.*;
public class sorting2DArray {

  public static void sort2D(int[][] array){
    Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));
    for(int[] a:array){
      System.out.println(Arrays.toString(a));
    }
  }

  public static void main(String[] args) {
    int[][] a={{2,3,4},{1,2},{7,5},{5,6}};
    sort2D(a);
  }
}
