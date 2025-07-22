//use of PQ
//intuition = GREEDY

package graph;
import java.util.*;
class Pair{
  int node;
  int distance;
  public Pair(int d,int n){
    node=n;
    distance=d;
  }
}
public class prims_Algorithm {
  static int spanningTree(int V,List<List<List<Integer>>> adj){
    PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
    int[] vis=new int[V];
    //{wt,node}
    pq.add(new Pair(0,0));
    int sum=0;

    //E log E + E log E
    //E log E
    while(pq.size()!=0){
      
      //log E
      int wt=pq.peek().distance;
      int node=pq.peek().node;
      pq.remove();
       if(vis[node]==1) continue;

       //add to the MST
       vis[node]=1;
       sum+=wt;
       
       //E log E
       for(int i=0;i<adj.get(node).size();i++){
        int edW=adj.get(node).get(i).get(1);
        int adjNode=adj.get(node).get(i).get(0);
        if(vis[adjNode]==0){
          pq.add(new Pair(edW,adjNode));
        }
       }
    }
    return sum;
  }
}
