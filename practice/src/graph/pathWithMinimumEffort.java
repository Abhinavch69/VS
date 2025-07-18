//dijkstra algorithm with priority queue
//inside PQ jb destination aajaye usa mtlb hume minimum distance mil gayi h

package graph;
import java.util.*;
class tuple{
  int distance,row,col;
  public tuple(int d,int r,int c){
    distance=d;row=r;col=c;
  }
}
public class pathWithMinimumEffort {
  int minimumEffort(int heights[][]){
    PriorityQueue<tuple> pq=new PriorityQueue<tuple>((x,y) -> x.distance - y.distance);

    int n=heights.length;
    int m=heights[0].length;
    int[][] dist=new int[n][m];
    for(int[] arr: dist){
      Arrays.fill(arr,(int)(1e9));
    }
    dist[0][0]=0;
    pq.add(new tuple(0,0,0));
    int dr[]={-1,0,1,0};
    int dc[]={0,1,0,-1};
    //E log V
    //n X m X 4 X log (n X m)
    while(pq.size()!=0){
      tuple it=pq.peek();
      pq.remove();
      int diff=it.distance;
      int row=it.row;
      int col=it.col;

      if(row== n-1 && col==m-1) return diff;

      for(int i=0;i<4;i++){
        int newr=row+dr[i];
        int newc=col+dc[i];
        if(newr>=0 && newc>=0 && newr<n && newc<m){
          int newEffort=Math.max(Math.abs(heights[row][col]-heights[newr][newc]),diff);
          if(newEffort < dist[newr][newc]){
            dist[newr][newc]=newEffort;
            pq.add(new tuple(newEffort,newr,newc));
          }
        }
      }
    }
    return 0;
  }
}
