package arrays;
import java.util.*;
public class findsecondlargestnumber {

  static int secondLargest(int[] arr, int n){
    int largest=-1;
    int largest2=-1;
    for(int i=0;i<n;i++){
      if(arr[i]>largest){
        largest=arr[i];
      }
    }
    for(int i=0;i<n;i++){
      if(arr[i]!=largest && arr[i]>largest2){
        largest2=arr[i];
      }
    }
    return largest2;
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    System.out.println("Enter the size of array");
    int n=sc.nextInt();
    int[] arr=new int[n];
    System.out.println("Enter the elements of array");
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    int ans=secondLargest(arr, n);
    System.out.println("Second largest element is "+ans);
  }
}