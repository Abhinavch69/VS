//Undirected Graph

import java.util.*;
public class $7detectCycle_BFS {

  class Pair{
    int first,second;
    public Pair(int f,int s){
      first=f;second=s;
    }
  }

  public  boolean checkForCycle(int src,int V,List<List<Integer>> adj, boolean[] vis){
    vis[src]=true;
    Queue<Pair> q=new LinkedList<>();
    q.add(new Pair(src,-1));

    while(!q.isEmpty()){
      int node=q.peek().first;
      int parent=q.peek().second;
      q.remove();

      for(Integer adjNode:adj.get(node)){
        if(vis[adjNode]==false){
          vis[adjNode]=true;
          q.add(new Pair(adjNode,node));
        }else if(parent!=adjNode){
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isCycle(int V, List<List<Integer>> adj){
    boolean vis[]=new boolean[V];
    for(int i=0;i<V;i++) vis[i]=false;
    for(int i=0;i<V;i++){
      if(vis[i]==false){
        if(checkForCycle(i,V,adj,vis)) return true;
      }
    }
    return false;
  }
}
