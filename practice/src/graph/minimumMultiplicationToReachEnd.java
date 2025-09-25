//dijkstra with queue
//{steps,num}
import java.util.*;
class Pair{
  int steps,node;
  public Pair(int d,int s){
    steps=s;
    node=d;
  }
}
public class minimumMultiplicationToReachEnd {
  int minimumMultiplications(int[] arr,int start,int end){
    if(start==end) return 0;
    Queue<Pair> q=new LinkedList<>();
    q.add(new Pair(start,0));
    int[] dist=new int[100000];
    Arrays.fill(dist,(int)(1e9));
    dist[start]=0;
    //0(100000 * arr.length)
    while(!q.isEmpty()){
      int node=q.peek().node;
      int steps=q.peek().steps;
      q.remove();

      for(int it:arr){
        int num=(it*node) % 100000;
        if(steps+1 < dist[num]){
          dist[num]=steps+1;
          if(num == end) return steps+1;
          q.add(new Pair(num,steps+1));
        }
      }
    }
    return -1;
  }
}
