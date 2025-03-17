package strings;

public class comparison {
    public static void main(String[] args) {
      String a="Abhinav";
      String b="Abhinav";

      //checks if reference variable points to same object or not
      System.out.println(a == b);

      //new keyword is used to create new objects explicitly
      String a1= new String("kunal");
      String b1=new String("kunal  ");

      //checks if values are same or not
      System.out.println(a1.equals(b1));

      System.out.println(a1.charAt(0));

     
    }
}
