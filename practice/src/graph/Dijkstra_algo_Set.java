import java.util.*;
class Pair{
  int distance;
  int node;
  public Pair(int d,int n){
    distance=d;node=n;
  }
}
public class Dijkstra_algo_Set {
  int[] dijkstra(int V,List<List<Pair>> adj,int S){
  TreeSet<Pair> st=new TreeSet<>(new Comparator<Pair>() {
    public int compare(Pair a, Pair b){
      if(a.distance==b.distance)
        return a.node-b.node;
      return a.distance-b.distance;
    }
  });
  int[] dist=new int[V];
  Arrays.fill(dist,(int)(1e9));
  st.add(new Pair(0,S));
  dist[S]=0;

  while(!st.isEmpty()){
    Pair current=st.pollFirst();
    int u=current.node;

    for(Pair neighbor:adj.get(u)){
      int v=neighbor.node;
      int wt=neighbor.distance;

      if(dist[u]+wt < dist[v]){
        //If a shorter path to v is found
        st.remove(new Pair(v,dist[v])); // Remoce the old pair
        dist[v]=dist[u]+wt;
        st.add(new Pair(dist[v],v));
      }
    }
  }
  return dist;
}
}
