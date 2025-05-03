package graph;
import java.util.*;
public class DFS_Traversal {
  public static void dfs(int node, boolean vis[], List<List<Integer>> adj, List<Integer> ls){
    vis[node]=true;
    ls.add(node);

    for(Integer it: adj.get(node)){
      if(!vis[it]){
        dfs(it, vis, adj, ls);
      }
    }
  }

  public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj){
    boolean vis[] = new boolean[V+1];
    for(int i=0;i<vis.length;i++){
      vis[i]=false;
    }
    vis[0]=true;
    List<Integer> ls=new ArrayList<>();
    for(int i=0;i<=V;i++){
      if(!vis[i]){
        dfs(i, vis, adj, ls);
      }
    }
    return ls;
  }
}
