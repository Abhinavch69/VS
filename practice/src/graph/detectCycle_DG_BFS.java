//Uses kahns algorithm
import java.util.*;
public class detectCycle_DG_BFS {
  public boolean isCyclic(int V,List<List<Integer>> adj){
    int indegree[]=new int[V];
      for(int i=0;i<V;i++){
        for(int it:adj.get(i)){
          indegree[it]++;
        }
      }
      Queue<Integer> q=new LinkedList<>();
      for(int i=0;i<V;i++){
        if(indegree[i]==0) q.add(i);
      }
      int cnt=0;
      while(!q.isEmpty()){
        int node=q.peek();
        q.remove();
        cnt++;

        for(int it:adj.get(node)){
          indegree[it]--;
          if(indegree[it]==0) q.add(it);
        }
      }
      //agr cnt number of vertices jitna hogaya to iska mtlb ki koi cycle nahi h graph m
    if(cnt==V) return false;
    return true;
  }
}
