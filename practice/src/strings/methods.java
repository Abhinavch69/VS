package strings;
import java.util.*;

public class methods {
  public static void main(String[] args) {
    String name="Abhinav Chauhan Hello world";
    //System.out.println(Arrays.toString(name.toCharArray()));
    //System.out.println(name.indexOf('a'));
    //String []arr1=Arrays.toString(name.split(" "))

    //System.out.println(Arrays.toString(name.split(" ")));

    String s="hi here the price is $10000 $6 7 8 $9";
    char []arr=s.toCharArray();
    System.out.println(""+Arrays.toString(arr));
    /*for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+"");
    }*/
    System.out.println();
    String []arr2=s.split(" ");
    System.out.println(Arrays.toString(arr2));
  }
}
