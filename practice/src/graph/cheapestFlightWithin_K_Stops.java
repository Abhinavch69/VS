//can make upto k stops excluding source and destination
//dijkstra but no need of PQ
// {stops,node,dist}
package graph;
import java.util.*;

import arrays.arraylist;
class Pair{
  int first,second;
  public Pair(int f,int s){
    first=f;second=s;
  }
}
class tuple{
  int first,second,third;
  public tuple(int f,int s,int t){
    first=f;
    second=s;third=t;
  }
}
public class cheapestFlightWithin_K_Stops {
  public int cheapestFlight(int n,int flights[][],int src,int dst,int K){
    List<List<Pair>> adj=new ArrayList<>();
    for(int i=0;i<n;i++){
      adj.add(new ArrayList<>());
    }
    int m=flights.length;
    for(int i=0;i<m;i++){
      adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
    }
    Queue<tuple> q=new LinkedList<>();
    //{stops,node,dist}
    q.add(new tuple(0,src,0));
    int[] dist=new int[n];
    Arrays.fill(dist,(int)(1e9));
    dist[src]=0;
    //E = flights.size()
    while(!q.isEmpty()){
      tuple it=q.peek();
      q.remove();
      int stops=it.first;
      int node=it.second;
      int cost=it.third;
      if(stops>K) continue;
      for(Pair iter:adj.get(node)){
        int adjNode=iter.first;
        int edW=iter.second;
        
        if(cost+edW < dist[adjNode] && stops<=K){
          dist[adjNode]=cost+edW;
          q.add(new tuple(stops+1,adjNode,cost+edW));
        }
      }
    }
    if(dist[dst]==(int)(1e9)) return -1;
    return dist[dst];
  }
}
