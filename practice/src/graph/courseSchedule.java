package graph;
import java.util.*;
public class courseSchedule {
  public boolean isPossible(int V,int[][] prerequisites){

    //form a graph
    List<List<Integer>> adj=new ArrayList<>();
    for(int i=0;i<V;i++){
      adj.add(new ArrayList<>());
    }
    int m=prerequisites.length;
    for(int i=0;i<m;i++){
      adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }
    int[] indegree=new int[V];
    for(int i=0;i<V;i++){
      for(int it:adj.get(i)){
        indegree[it]++;
      }
    }
    Queue<Integer> q=new LinkedList<>();
    for(int i=0;i<V;i++){
      if(indegree[i]==0) q.add(i);
    }
    List<Integer> topo=new ArrayList<>();
    while(!q.isEmpty()){
      int node=q.peek();
      q.remove();
      topo.add(node);

      for(int it:adj.get(node)){
        indegree[it]--;
        if(indegree[it]==0) q.add(it);
      }
    }
    if(topo.size()==V) return true;
    return false;
  }
}
