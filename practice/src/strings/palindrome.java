package strings;
import java.util.*;
public class palindrome {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter a string");
    String s=sc.nextLine().toLowerCase();
    boolean bool=true;
    for(int i=0;i<s.length();i++){
      if(s.charAt(i)!=s.charAt(s.length()-1-i)){
        System.out.println("Not a palindrome");
        bool=false;
        break;
      }
    }
    if(bool)
    System.out.println("Palindrome");
  }
}
