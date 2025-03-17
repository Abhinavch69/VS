package recursion_subset_subssequence_string;

import java.util.*;

public class subset {
  public static void main(String[] args) {
    int[] arr={1,2,3};
    List<List<Integer>> ans= Subset(arr);
    for(List<Integer> list: ans){
      System.out.println(list);
    }
  }
  
  static List<List<Integer>> Subset(int[] arr){
    List<List<Integer>> outer=new ArrayList<>();

    outer.add(new ArrayList<>());

    for(int num : arr){
      int n=outer.size();
      for(int i=0;i<n;i++){
        List<Integer> internal =new ArrayList<>(outer.get(i));
        internal.add(num);
        outer.add(internal);
      }
    }

    return outer;
  }
}
