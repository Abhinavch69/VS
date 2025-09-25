//In this question we will be provided with adjacency matrix
//we have to convert it into adjacency list
import java.util.*;
public class $3numberOfProvinces {

    public static void dfs(int node,List<List<Integer>> adjLs,int[] vis){
      vis[node]=1;
      for(Integer it:adjLs.get(node)){
        dfs(it, adjLs, vis);
      }
    }

    public int numProvinces(List<List<Integer>> adj, int V){
      List<List<Integer>> adjLs=new ArrayList<>();
      for(int i=0;i<V;i++){
        adjLs.add(new ArrayList<>());
      }

      //Change into adjacency list
      for(int i=0;i<V;i++){
        for(int j=0;j<V;j++){
          if(adj.get(i).get(j)==1 && i!=j){
            adjLs.get(i).add(j);
            adjLs.get(j).add(i);
          }
        }
      }
      int vis[]=new int[V];
      int cnt=0;
      for(int i=0;i<V;i++){
        if(vis[i]==0){
          cnt++;
          dfs(i,adjLs,vis);
        }
      }
      return cnt;
    }
}
