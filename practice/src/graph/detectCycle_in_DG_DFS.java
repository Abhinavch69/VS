//DFS
//on the same path node has to visited again
import java.util.*;
public class detectCycle_in_DG_DFS {
  private static boolean dfsCheck(int node, List<List<Integer>> adj,int vis[], int pathVis[]){
    vis[node]=1;
    pathVis[node]=1;

    //traverse for adjacent node
    for(int it:adj.get(node)){
      //when the node i snot visited
      if(vis[it]==0){
        if(dfsCheck(it, adj, vis, pathVis)==true) return true;
      }

      //if the node has been previously visited
      //but it has to be visited on the same path
      else if(pathVis[it]==1) return true;
    }

    pathVis[node]=0;
    return false;
  }

  public boolean isCuclic(int V, List<List<Integer>> adj){
    int[] vis=new int[V];
    int[] pathVis=new int[V];
    for(int i=0;i<V;i++){
      if(vis[i]==0){
        if(dfsCheck(i,adj,vis,pathVis)==true) return true;
      }
    }
    return false;
  }
}
