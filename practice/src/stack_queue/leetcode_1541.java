/*
 * Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.

For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
You can insert the characters '(' and ')' at any position of the string to balance it if needed.

Return the minimum number of insertions needed to make s balanced.

 
 */

package stack_queue;
import java.util.*;
public class leetcode_1541 {
  static public int minInsertions(String s) {
        Stack<Character> stack=new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
          if(s.charAt(i)=='('){
            stack.push(s.charAt(i));
          }
          if(s.charAt(i)==')' && s.charAt(i+1)==')' && stack.peek()=='('){
          stack.pop();
          }else{
            count++;
          }
        }
        return stack.size()+count;
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter a string");
    String s=sc.next();
    System.out.println(minInsertions(s));
  }
}
