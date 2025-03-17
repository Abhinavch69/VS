package strings;

import java.util.ArrayList;

public class operators {
  public static void main(String[] args) {
    System.out.println('a'+'b');
    System.out.println("a"+"b");
    System.out.println((char)('a'+3));

    //integer will convert into Integer wrapper class that will call toSring()
    System.out.println("a"+1);
    //it is same as "a"+"1"

    System.out.println("kunal"+ new ArrayList<>());
    System.out.println("Kunal"+ new Integer(56));

    String ans = new Integer(56) + "" + new ArrayList<>();
    System.out.println(ans);

    
  }
}
