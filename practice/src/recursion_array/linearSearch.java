package recursion_array;
import java.util.*;
public class linearSearch {

  static boolean find(int[] arr,int target, int index){
    if(index == arr.length){
      return false;
    }
    return arr[index]==target || find(arr, target, index+1);
  }

  static int findIndex(int[] arr,int target, int index){
    if(index == arr.length){
      return -1;
    }
    if(arr[index]==target) return index;
    else
    return  findIndex(arr, target, index+1);
  }

  static ArrayList<Integer> list=new ArrayList<>();
  static void findAllIndex(int[] arr,int target, int index){
    if(index == arr.length){
      return ;
    }
    if(arr[index]==target) list.add(index);
    
    findAllIndex(arr, target, index+1);
  }
  public static void main(String[] args) {
    int[] arr={1,2,3,4,4,5};
    System.out.println(findIndex(arr, 4, 0));
    findAllIndex(arr, 4, 0);
    System.out.println(list);
  }
}
