package arrays;
import java.util.*;
public class intro {

  public static void main(String[] args) {
    
    Scanner sc=new Scanner(System.in);
    //syntax
    //datatype[] variable_name=new datatype[size];

    int[] rollno=new int[5];
  
    int[] rnos2={23,12,23,34,56};

    //breaking of syntax

    //new is the keyword used to create objects

    int[] ros; //declaration of array. ros is getting defined in the stack. Happens in compile time

    ros=new int[5]; //initialisaton: actually here object is being created in the heap memory. 
    //Happens in runtime also known as dynamic memory allocation

    //array objects are created in heap
    //heap objects are not continuous in memory
    //dynamic memory allocation

    //hence: array may not be contiguous -> totallt depends on JVM

    //any reference variable will have a null value by default

    //input
    int[] arr=new int[5];

    //input using for loops
    for(int i=0;i<arr.length;i++){
      arr[i]=sc.nextInt();
    }

    //Enhanced for loop: for-each loop
    for(int num:arr){ //for every element in array, print the element
      System.out.print(num+" "); //here num represents element of the array
    }
    
    //System.out.println(arr[5]);   array index out of bounds error
    System.out.println();
    System.out.println(Arrays.toString(arr));

    //arrays of objects

    String[] str=new String[4];
    for(int i=0;i<str.length;i++){
      str[i]=sc.next();
    }

    System.out.println(Arrays.toString(str));
  }
}
