package arrays;
import java.util.*;
public class equilibrimPoint {

  //using prefix sum and suffix sum method
  static int equilibrimpoint(int[] arr,int n){
    int presum=0;
    int suffixsum=0,totalsum=0;

    //finding total sum
    for(int i=0;i<n;i++){
      totalsum+=arr[i];
    }
    for(int i=0;i<n;i++){
      suffixsum=totalsum-presum-arr[i];
      if(presum==suffixsum)
      return i;

      presum=presum+arr[i];
    }
    return -1;
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
    int ans=equilibrimpoint(arr, n);
    if(ans>-1)
    System.out.println("The pivot is at index "+ans);
    else
    System.out.println("No pivot found");
  }
}
