package arrays;
import java.util.*;
public class removDuplicate {

  static int duplicates(int[] arr, int n){
    if(n<=1){
      return n;
    }
    int index=1;
    for(int i=1;i<n;i++){
      if(arr[i]!=arr[i-1]){
        arr[index++]=arr[i];
      }
    }
    return index;
  }

  static void display(int[] arr){
    
    System.out.print(Arrays.toString(arr));
  
}
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n=sc.nextInt();
    int arr[]=new int[n];
    System.out.println("Enter the elements of array");
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    System.out.println("Original Array");
    display(arr);
    int newSize=duplicates(arr, n);
    System.out.println("\nArray after removing duplicates");
    display(Arrays.copyOf(arr, newSize));
  }
}
