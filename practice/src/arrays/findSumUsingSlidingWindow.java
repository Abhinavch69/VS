package arrays;
import java.util.*;
public class findSumUsingSlidingWindow {

  
  
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
  }
}
