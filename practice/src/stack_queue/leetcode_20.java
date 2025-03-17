

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.package stack_queue;
*/

package stack_queue;
import java.util.*;
public class leetcode_20 {
  public boolean isValid(String s){
    Stack<Character> stack=new Stack<>();

    for(char ch : s.toCharArray()){
        if(ch =='('  || ch =='{' || ch=='['){
          stack.push(ch);
        }else{
          if(ch==')'){
            //checking if stack is empty or not first to make sure we do not pop element from an empty stack
            if( stack.isEmpty() || stack.pop()!='(')
            return false;
          }
          if(ch=='}'){
            if(stack.isEmpty() || stack.pop()!='{')
            return false;
          }
          if(ch==']'){
            if(stack.isEmpty() || stack.pop()!='[' )
            return false;
          }
        }
    }
    return stack.isEmpty();
  }
}
