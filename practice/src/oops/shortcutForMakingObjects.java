package oops;
import java.util.*;

record Flower(String flower,int petals, float price){}
public class shortcutForMakingObjects{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    Flower[] fl=new Flower[5];
    for(int i=0;i<5;i++){
      System.out.println("Enter the details for flower "+(i+1));
      System.out.println("Name: ");
      String name=sc.next();
      System.out.println("Number of petals: ");
      int pet=sc.nextInt();
      System.out.println("Price of flower: ");
      float pr=sc.nextFloat();
      fl[i]=new Flower(name, pet, pr);
    }

    for(int i=0;i<5;i++){
      System.out.println("Details of flower "+(i+1));
      System.out.println("Name of flower: "+fl[i].flower()+" ,Number of petals: "+fl[i].petals()+" ,Price: "+fl[i].price());
    }
  }
}