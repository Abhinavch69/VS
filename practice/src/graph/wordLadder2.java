package graph;
import java.util.*;
public class wordLadder2 {
  public List<List<String>> findSequences(String startWord,String targetWord,String[] wordList){
    Set<String> st=new HashSet<>();
    int len=wordList.length;
    for(int i=0;i<len;i++) st.add(wordList[i]);
    Queue<List<String>> q=new LinkedList<>();
    List<String> ls=new ArrayList<>();
    ls.add(startWord);
    q.add(ls);
    List<String> usedOnLevel=new ArrayList<>();
    usedOnLevel.add(startWord);
    int level=0;
    List<List<String>> ans=new ArrayList<>();
    while(!q.isEmpty()){
      List<String> vec=q.peek();
      q.remove();

      //erase all words that has been used in the previous levels to transform
      if(vec.size()>level){
        level++;
        for(String it:usedOnLevel){
          st.remove(it);
        }
      }
      String word=vec.get(vec.size()-1);
      if(word.equals(targetWord)){
        //the first sequence where we reached end
        if(ans.size()==0) ans.add(vec);
        else if(ans.get(0).size()==vec.size()) ans.add(vec);
      }
      for(int i=0;i<word.length();i++){
        for(char c='a';c<='z';c++){
          char replacedCharArray[]=word.toCharArray();
          replacedCharArray[i]=c;
          String replacedWord=new String(replacedCharArray);
          if(st.contains(replacedWord)==true){
            vec.add(replacedWord);
            //Java works by reference
            List<String> temp=new ArrayList<>(vec);
            q.add(temp);
            //mark as visited on the level
            usedOnLevel.add(replacedWord);
            vec.remove(vec.size()-1);
          }
        }
      }
    }
    return ans;
  }
}
