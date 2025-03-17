package arrays;
import java.util.*;
public class majorityElementInArray {

  //Using moore's voting algorithm 

  static int majorityElement(int[] arr,int n){
    int count = 0;
    int candidate = 0;

    //finding the candidate
    for(int i = 0; i < n; i++) {
      if(count == 0) {
        candidate=arr[i];
        count=1;
      }else if(arr[i]==candidate){
        count++;
      }else{
        count--;
      }
    }

    //finding the number of frequencies of the candidate
    count=0;
    for(int i=0;i<n;i++){
      if(arr[i]==candidate){
        count++;
      }
    }

    //checking if frequency of candidate is more than n/2 or not
    if(count > n/2){
      return candidate;
    }else{
      return -1;
    }
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
    System.out.println("Majority elemnt in array is "+majorityElement(arr, n));
  }
}
