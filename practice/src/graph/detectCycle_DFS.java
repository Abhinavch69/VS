package graph;
import java.util.*;

class Pair{
  int first,second;
  public Pair(int f,int s){
    first=f;second=s;
  }
}
public class detectCycle_DFS {

  public boolean checkForCycle(int node,int parent,List<List<Integer>> adj,boolean[] vis){
    vis[node]=true;
    for(Integer adjNode:adj.get(node)){
      if(vis[adjNode]==false){
        if(checkForCycle(adjNode, node, adj, vis)){
          return true;
        }
        }
        else if(adjNode!=parent){
          return true;
      }
    }
    return false;
  }
  public boolean isCycle(int V, List<List<Integer>> adj){
    boolean vis[]=new boolean[V];
    for(int i=0;i<V;i++) vis[i]=false;
    for(int i=0;i<V;i++){
      if(vis[i]==false){
        if(checkForCycle(i,-1,adj,vis)) return true;
      }
    }
    return false;
  }
}
