package bitManipulation;
import java.util.*;
public class countSetBits {

  static int[] countBits(int[] arr, int n){
    int[] res = new int[n];
    int index=0;
    for(int x:arr){
      int count=0;
      while(x>0){

        //doing x&1 to find if LSB is 1 or not
        count=count+(x&1);

        //right shifting the number
        x=x>>1;
      }
      res[index]=count;
      index++;
    }
    return res;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter size of array");
    int n=sc.nextInt();
    int[] arr=new int[n];
    System.out.println("Enter elements of array");
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    System.out.println("Array is");
    System.out.println(Arrays.toString(arr));
    int[] res=countBits(arr, n);
    System.out.println("Count of set bits in array is");
    System.out.println(Arrays.toString(res));
  }
}
