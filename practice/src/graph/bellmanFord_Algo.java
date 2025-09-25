//shortest distance
//helps to detect negative cycle
//applicabe only on DG
//relax all the edges N-1 times sequentially
//Why N-1 ?
//Sice in a graph of N nodes, in worst case, 
//you will take N-1 edges to reach from the first to the last,
//thereby we iterate for N-1 iterations.
//Try drawing a graph which takes more than N-1 edges for any path,
//it is not possible.

//How to detect negative cycle
//if at Nth iteration the distance array is still updating(means decreasing)
//it means there is a negative cycle


import java.util.*;
public class bellmanFord_Algo {
  static int[] bellman_ford(int V,List<List<Integer>> edges,int S){
    int[] dist=new int[V];
    Arrays.fill(dist,(int)(1e8));
    dist[S]=0;
    //V x E
    for(int i=0;i<V-1;i++){
      for(List<Integer> it:edges){
        int u=it.get(0);
        int v=it.get(1);
        int wt=it.get(2);
        if(dist[u] != 1e8 && dist[u]+wt < dist[v]){
          dist[v]=dist[u]+wt;
        }
      }
    }
    //Nth relaxation to check negative cycle'
    for(List<Integer> it:edges){
      int u=it.get(0);
      int v=it.get(1);
      int wt=it.get(2);
      if(dist[u] != 1e8 && dist[u]+wt < dist[v]){
        int temp[]={-1};
        return temp;
      }
    }
    return dist;
  }
}
