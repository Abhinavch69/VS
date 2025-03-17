package strings;

class playwithcharacter{
  public static void main(String[] args) {
    String s="111";
    System.out.println(s.charAt(0));

    //it gives as ascii values of the characters
    int num=(int)(s.charAt(0));
    System.out.println(num);

    //convert char into integer
    int n=s.charAt(0) - '0';
    System.out.println(n);

    String s1= 123+""+12;
    System.out.println(s1);

     //substring
     String str="abhinav";
     String str1=str.substring(1,5);
     System.out.println(str1);

     //string to integer
     String s5="1234";
     int n5=Integer.parseInt(s5);
     System.out.println(s5);
  }
}