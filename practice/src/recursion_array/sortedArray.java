package recursion_array;
import java.util.*;
public class sortedArray {

  static boolean sorted(int [] arr, int index){
    if(index==arr.length-1) return true;

    return arr[index]<arr[index+1] && sorted(arr,index+1);
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int[] arr={1,2,3,7,5};
    if(sorted(arr, 0))
    System.out.println("Array is sorted");
    else
    System.out.println("Array is not sorted");
  }
}
