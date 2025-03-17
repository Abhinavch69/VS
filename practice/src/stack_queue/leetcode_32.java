package stack_queue;
import java.util.*;
public class leetcode_32 {

  public static int longestValidParentheses(String s) {
    if(s.length()==0) return 0;
    Stack stack=new Stack();
    int count=0;
    for(char ch:s.toCharArray()){
        if(ch=='('){
            if(stack.isEmpty()){
                stack.push(ch);
            }else{
                count=0;
                stack.pop();
                stack.push(ch);
            }
        }
        else{
            if(stack.isEmpty()){
                continue;
            }else{
                stack.pop();
                count+=2;
            }
        }
    }
    return count;
}
  public static void main(String[] args) {
    
  }
}
