package graph;
import java.util.*;
class Pair{
  String first;
  int second;
  Pair(String f,int s){
    this.first=f;
    this.second=s;
  }
}
public class wordLadder1 {
  public int wordLadderLength(String startWord, String endWord,String[] wordList){
    Queue<Pair> q=new LinkedList<>();
    q.add(new Pair(startWord,1));
    Set<String> st=new HashSet<>();
    for(int i=0;i<wordList.length;i++){
      st.add(wordList[i]);
    }
    st.remove(startWord);
    while(!q.isEmpty()){
      String word=q.peek().first;
      int steps=q.peek().second;
      q.remove();
      if(word.equals(endWord)==true) return steps;

      for(int i=0;i<word.length();i++){
        for(char ch='a';ch<='z';ch++){
          char[] replacedCharArray=word.toCharArray();
          replacedCharArray[i]=ch;
          String replacedWord=new String(replacedCharArray);
          //it exists in the set
          if(st.contains(replacedWord)==true){
            st.remove(replacedWord);
            q.add(new Pair(replacedWord,steps+1));
          }
        }
      }
    }
    return 0;
  }
}
