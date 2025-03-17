package arrays;
import java.util.*;

//KADANE'S ALGORITHM
public class maximumSubArraySum {

  static int kadaneAlgorithm(int[] arr, int n){
    int res=arr[0];
    int maxres=arr[0];
    for(int i=1;i<n;i++){

      // Find the maximum sum ending at index i by either extending 
      // the maximum sum subarray ending at index i - 1 or by
      // starting a new subarray from index i
      maxres=Math.max(arr[i],maxres+arr[i]);

      // Update res if maximum subarray sum ending at index i > res
      res = Math.max(res, maxres);
    }
    return res;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter size of the array");
    int n=sc.nextInt();
    int arr[]=new int[n];
    System.out.println("Enter elements of the array");
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    System.out.println("Array is:");
    System.out.println(Arrays.toString(arr));

    System.out.println("MAximum sum of subarray is: "+kadaneAlgorithm(arr, n));
  }
}
