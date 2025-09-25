//BFS
import java.util.*;
public class BipartiteGraph_BFS {
  private boolean check(int start,int V,List<List<Integer>> adj,int[] color){
    Queue<Integer> q=new LinkedList<>();
    q.add(start);
    color[start]=0;
    while(!q.isEmpty()){
      int node=q.peek();
      q.remove();

      for(Integer it:adj.get(node)){

        //if the adjacent node is yet not colored
        //you will give the opposite color of the node
        if(color[it]==-1){
          q.add(it);
          color[it]=1-color[node];
        }
        //is the adjacent guy having the same color
        //someone did color it on some othert path
        else if(color[it]==color[node]){
          return false;
        }
      }
    }
    return true;
  }

  public boolean isBipartite(int V,List<List<Integer>> adj){
    int[] color=new int[V];
    for(int i=0;i<V;i++) color[i]=-1;
    for(int i=0;i<V;i++){
      if(color[i]==-1){
        if(check(i,V,adj,color)==false) return false;
      }
    }
    return true;
  }
}
