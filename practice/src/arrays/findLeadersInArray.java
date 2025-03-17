package arrays;
import java.util.*;
public class findLeadersInArray {

  static ArrayList<Integer> leaders(int[] arr, int n){
    ArrayList<Integer> list=new ArrayList<>();
    int max_right=arr[n-1];
    list.add(max_right);
    for(int i=n-2;i>=0;i--){
      if(arr[i]>max_right){
        max_right=arr[i];
        list.add(arr[i]);
      }
    }
    Collections.reverse(list);
    return list;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the size of the array");
    int n=sc.nextInt();
    int arr[]=new int[n];
    System.out.println("Enter the elements of the array");
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    System.out.println(Arrays.toString(arr));
    System.out.println("Array after finding leaders");
    ArrayList<Integer> result=leaders(arr,n);
    for(int res: result){
      System.out.print(res+" ");
    }
  }
}
