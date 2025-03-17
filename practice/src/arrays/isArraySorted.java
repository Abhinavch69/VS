package arrays;
import java.util.*;;
public class isArraySorted {

  static void isSorted(int[] arr, int n){
    for(int i=0; i<n-1; i++){
      if(arr[i]>arr[i+1]){
        System.out.println("Array is not sorted");
        return;
      }
    }
    System.out.println("Array is sorted");
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
    isSorted(arr, n);
  }
}
