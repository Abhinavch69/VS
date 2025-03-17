package recursion_subset_subssequence_string;

import java.util.ArrayList;

public class subsequence {
  public static void main(String[] args) {
    //subseq("", "abc");
    //ArrayList<String> list=subseq2("", "abc");
    //System.out.println(list);
    subseqAscii("", "abc");
  }
  static void subseq(String p,String up){
    if(up.isEmpty()){
      System.out.println(p);
      return;
    }

    char ch=up.charAt(0);

    subseq(p+ch, up.substring(1));
    subseq(p, up.substring(1));
  }

  static ArrayList<String> subseq2(String p,String up ){
    if(up.isEmpty()){
      ArrayList<String> list=new ArrayList<>();
      list.add(p);
      return list;
    }

    char ch=up.charAt(0);

    ArrayList<String> left= subseq2(p+ch, up.substring(1));
    ArrayList<String> right=subseq2(p, up.substring(1));
    left.addAll(right);
    return left;
  }

  static void subseqAscii(String p,String up){
    if(up.isEmpty()){
      System.out.println(p);
      return;
    }

    char ch=up.charAt(0);

    subseqAscii(p+ch, up.substring(1));
    subseqAscii(p, up.substring(1));
    subseqAscii(p+(ch+0), up.substring(1));
  }
}
