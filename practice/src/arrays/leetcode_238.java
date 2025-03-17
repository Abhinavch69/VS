//product of array except self
//using refix product and suffix product

package arrays;

import java.util.Arrays;

public class leetcode_238 {

  static public int[] productExceptSelf(int[] nums) {
    int n=nums.length;
    int[] ans=new int[n];
    int[] pre=new int[n];
    int[] suffix=new int[n];
    pre[0]=1;
    suffix[n-1]=1;

    //calculating prefix product from 1 to nums.length-2;
    for(int i=1;i<n;i++){
      pre[i]=pre[i-1]*nums[i-1];
    }

    //calculating suffix product from nums.length-2 to 0;
    for(int i=n-2;i>=0;i--){
      suffix[i]=suffix[i+1]*nums[i+1];
    }

    for(int i=0;i<n;i++){
      ans[i]=pre[i]*suffix[i];
    }
    return ans;
  }
  public static void main(String[] args) {
    int[] mat={-1,1,0,-3,3};
    int[] ans=productExceptSelf(mat);
    System.out.println(Arrays.toString(ans));
  }
  
}
