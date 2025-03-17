package arrays;
import java.util.*;

public class moveZerosToTheEnd {

  static void shiftZerosToTheEnd(int[] arr,int n){
    int count = 0;
    for (int i = 0; i < n; i++) {
      if(arr[i]!=0){
        arr[count]=arr[i];
        count++;
      }
    }
    while(count<n){
      arr[count]=0;
      count++;
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
    System.out.println("Array before shifting");
    System.out.println(Arrays.toString(arr));
    shiftZerosToTheEnd(arr,n);
    System.out.println("Array after shifting");
    System.out.println(Arrays.toString(arr));
  }
}
