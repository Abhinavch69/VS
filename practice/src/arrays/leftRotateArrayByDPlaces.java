/* 
The idea is based on the observation that if we left rotate the array by d positions, the last (n – d) elements will be at the front and the first d elements will be at the end. 


1. Reverse the subarray containing the first d elements of the array.
2. Reverse the subarray containing the last (n – d) elements of the array.
3. Finally, reverse all the elements of the array.
*/


package arrays;
import java.util.*;
public class leftRotateArrayByDPlaces {

  static void reverseArray(int [] arr, int start, int end){
    while(start < end){
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  static void rotateArray(int[] arr ,int n, int d){
    d = d % n;
    reverseArray(arr, 0, d - 1);
    reverseArray(arr, d, n - 1);
    reverseArray(arr, 0, n - 1);
  }
  static void display(int[] arr){
    
    System.out.print(Arrays.toString(arr));
  
  }


  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Eter size of array");
    int n=sc.nextInt();
    int arr[]=new int[n];
    System.out.println("Enter elements of array");
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    System.out.println("Enter number of places to rotate");
    int d=sc.nextInt();
    System.out.println("Before rotating the array is");
    display(arr);
    rotateArray(arr, n, d);
    System.out.println("\nAfter rotating the array is");
    display(arr);
  }
}
