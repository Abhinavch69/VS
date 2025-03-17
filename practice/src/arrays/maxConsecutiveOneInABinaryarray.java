package arrays;
import java.util.*;
public class maxConsecutiveOneInABinaryarray {

  static int countOnes(int[] arr, int n){

        //checking if array have any 1 or not
        int count1=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1)
            count1++;
        }
        if(count1==0)
        return 0;
        int maxCount = 0, count = 0, prev = -1;


        for (int num : arr) {
            // If the current number is the same as the previous number
            if ((prev ^ num) == 0 && prev==1 && num==1) {
                count++;
            } else {
                // Update maxCount and reset count
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
            prev = num;
        }

        return Math.max(maxCount, count);
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter size of array");
    int n=sc.nextInt();
    int arr[]=new int[n];
    System.out.println("Enter elements of binary array");
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    System.out.println(Arrays.toString(arr));
    System.out.println("Maximum consecutive ones in binary array is "+countOnes(arr,n));
  }
}
