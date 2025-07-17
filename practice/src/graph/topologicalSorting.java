//Always happends on Directed Acyclic Graph
//DFS
//jiska dfs complete hojaye usse stack m push krdo
package graph;
import java.util.*;
public class topologicalSorting {
  private static void dfs(int node, int vis[], Stack<Integer> st,List<List<Integer>> adj){
    vis[node]=1;
    for(int it:adj.get(node)){
      if(vis[it]==0){
        dfs(it,vis,st,adj);
      }
    }
    st.push(node);
  }
  static int[] toposort(int V,List<List<Integer>> adj){
    int vis[]=new int[V];
    Stack<Integer> st=new Stack<>();
    for(int i=0;i<V;i++){
      if(vis[i]==0){
        dfs(i, vis, st, adj); 
      }
    }
    int ans[]=new int[V];
    int i=0;
    while(!st.isEmpty()){
      ans[i++]=st.peek();
      st.pop();
    }
    return ans;
  }
}
