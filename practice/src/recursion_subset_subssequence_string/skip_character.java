package recursion_subset_subssequence_string;

public class skip_character {
  public static void main(String[] args) {
    skip("", "baccdab");
    System.out.println(skip1("abbacad"));
    System.out.println(skipApple("bcadappledhbc"));
    System.out.println(skipAppWhenNotApple("sjbdqiubappsdcapplejdbc"));
  }

  static void  skip(String p,String up){
    if(up.isEmpty()){
      System.out.println(p);
      return;
    }

    char ch=up.charAt(0);
    if(ch=='a'){
      skip(p,up.substring(1));
    }else{
      skip(p+ch, up.substring(1));
    }
  }

  static String  skip1(String up){
    if(up.isEmpty()){
      return "";
    }

    char ch=up.charAt(0);
    if(ch=='a'){
      return skip1(up.substring(1));
    }else{
      return ch+skip1( up.substring(1));
    }
  }

  static String  skipApple(String up){
    if(up.isEmpty()){
      return "";
    }

    if(up.startsWith("apple")){
      return skipApple(up.substring(5));
    }else{
      return up.charAt(0)+skipApple( up.substring(1));
    }
  }

  static String  skipAppWhenNotApple(String up){
    if(up.isEmpty()){
      return "";
    }

    if(up.startsWith("app") && !up.startsWith("apple")){
      return skipAppWhenNotApple(up.substring(3));
    }else{
      return up.charAt(0)+skipAppWhenNotApple( up.substring(1));
    }
  }
}
