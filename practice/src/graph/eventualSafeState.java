//dfs

package graph;
import java.util.*;
public class eventualSafeState {
  private boolean dfsCheck(int node,List<List<Integer>> adj,int vis[],int pathVis[],int check[]){
    vis[node]=1;
    pathVis[node]=1;
    //traverse for adjacent node
    for(int it:adj.get(node)){
      //when node is not visited
      if(vis[it]==0){
        if(dfsCheck(it, adj, vis, pathVis, check)==true) 
        return true;
      }
      else if(pathVis[it]==1){
        return true;
      }
    }
    check[node]=1;
    pathVis[node]=0;
    return false;
  }

   List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj){
    int[] vis=new int[V];
    int[] pathVis=new int[V];
    int[] check=new int[V];
    for(int i=0;i<V;i++){
      if(vis[i]==0){
        dfsCheck(i,adj,vis,pathVis,check);
      }
    }
    List<Integer> safeNodes=new ArrayList<>();
    for(int i=0;i<V;i++){
      if(check[i]==1) safeNodes.add(i);
    }
    return safeNodes;
  }
}
