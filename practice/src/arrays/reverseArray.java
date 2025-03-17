package arrays;
import java.util.*;
public class reverseArray {

  static void reverse(int[] arr,int n){
    int start =0;
    int end=arr.length-1;
    while(start<=end){
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  static void display(int[] arr){
    
      System.out.print(Arrays.toString(arr));
    
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter size of array");
    int n=sc.nextInt();
    int arr[]=new int[n];
    System.out.println("Enter elements of array");
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    System.out.println("Array before reversing");
    display(arr);
    reverse(arr, n);
    System.out.println("\nReversed array is");
    display(arr);
  }
}
