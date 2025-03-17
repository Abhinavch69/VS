package bitManipulation;
import java.util.*;
public class toNonRepeatinElement {

  static ArrayList<Integer> nonRepeatingIntegers(int[] arr, int n){
    int xorVal=0;
    for(int x:arr){
      xorVal^=x;
    }

    // Get its last set bit
    xorVal=xorVal & -xorVal;

    ArrayList<Integer> list=new ArrayList<>(Arrays.asList(0, 0));
    for(int num:arr){

      // If bit is not set, it 
      // belongs to first set.
      if((xorVal & num)==0){
        list.set(0,list.get(0)^num);
      } 
      
      // If bit is set, it 
      // belongs to 2nd set.
      else{
        list.set(1,list.get(1)^num);
      }
    }

      if(list.get(0)>list.get(1)){
        int temp=list.get(0);
        list.set(0,list.get(1));
        list.set(1,temp);
      }
      return list;
    }
  
  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    System.out.println("Enetr size of array");
    int n=sc.nextInt();
    int arr[]=new int[n];
    System.out.println("Enter elements of array");
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    System.out.println("Array is");
    System.out.println(Arrays.toString(arr));

    ArrayList<Integer> list=nonRepeatingIntegers(arr, n);
    System.out.println(list.get(0)+" "+list.get(1));
  }
}
