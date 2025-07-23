//at least one mail should be same
//name does not matter neither does the order
//disJoint is being used

package graph;
import java.util.*;
public class accountMerge {
  static List<List<String>> account(List<List<String>> details){
    int n=details.size();
    disjoint_Set ds=new disjoint_Set(n);
    HashMap<String,Integer> mapMailNode=new HashMap<>();
    for(int i=0;i<n;i++){
      for(int j=1;j<details.get(i).size();j++){
        String mail=details.get(i).get(j);
        if(mapMailNode.containsKey(mail)==false){
          mapMailNode.put(mail,i);
        }else{
          ds.unionBySize(i, mapMailNode.get(mail));
        }
      }
    }
    List<String>[] mergedMail=new ArrayList[n];
    for(int i=0;i<n;i++){
      mergedMail[i]=new ArrayList<String>();
    }

    for(Map.Entry<String,Integer> it:mapMailNode.entrySet()){
      String mail=it.getKey();
      int node=ds.findUPar(it.getValue());
      mergedMail[node].add(mail);
    }
    List<List<String>> ans=new ArrayList<>();
    for(int i=0;i<n;i++){
      if(mergedMail[i].size()==0) continue;
      Collections.sort(mergedMail[i]);
      List<String> temp=new ArrayList<>();
      temp.add(details.get(i).get(0));
      for(String it: mergedMail[i]){
        temp.add(it);
      }
      ans.add(temp);
    }
    return ans;
  }
}
