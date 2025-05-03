//In this quesion we can move in 8 directions

package graph;
import java.util.*;

class Pair{
  int first;
  int second;
  public Pair(int first,int second){
    this.first=first;
    this.second=second;
  }
}
class numberOfIslands {

  public static void bfs(int ro,int co, int[][] vis, char[][]grid){
    vis[ro][co]=1;
    Queue<Pair> q=new LinkedList<>();
    q.add(new Pair(ro,co));
    int n=grid.length;
    int m=grid[0].length;
    
    while(!q.isEmpty()){
      int row=q.peek().first;
      int col=q.peek().second;
      q.remove();

      for(int delRow=-1;delRow<=1;delRow++){
        for(int delCol=-1;delCol<=1;delCol++){
          int nRow=row+delRow;
          int nCol=col+delCol;
          if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]=='1' && vis[nRow][nCol]==0){
            vis[nRow][nCol]=1;
            q.add(new Pair(nRow,nCol));
          }
        }
      }
    }
  }

  public int numIslands(char[][] grid){
    int n=grid.length;
    int m=grid[0].length;
    int[][]vis=new int[n][m];
    int cnt=0;
    for(int row=0;row<n;row++){
      for(int col=0;col<m;col++){
        if(vis[row][col]==0 && grid[row][col]=='1'){
          cnt++;
          bfs(row,col,vis,grid);
        }
      }
    }
    return cnt;
  }
}
