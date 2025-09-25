//kind of a online query question
//formula(row,col) = (row*m)+col
import java.util.*;
public class numberOfIsland_DisjointSet {
  private boolean isValid(int adjr,int adjc,int n,int m){
    return adjr>=0 && adjr<n && adjc>=0 && adjc<m;
  }
  public List<Integer> numOfIslands(int n,int m,int[][] operators){
    disjoint_Set ds=new disjoint_Set(n*m);
    int[][] vis=new int[n][m];
    int cnt=0;
    List<Integer> ans=new ArrayList<>();
    int len=operators.length;
    for(int i=0;i<len;i++){
      int row=operators[i][0];
      int col=operators[i][1];
      if(vis[row][col]==1){
        ans.add(cnt);
        continue;
      }
      vis[row][col]=1;
      cnt++;

      int dr[]={-1,0,1,0};
      int dc[]={0,1,0,-1};
      for(int ind=0;ind<4;ind++){
        int adjr=row+dr[ind];
        int adjc=col+dc[ind];
        if(isValid(adjr,adjc,n,m)){
          if(vis[adjr][adjc]==1){
            int nodeno=row*m+col;
            int adjNodeNo=adjr*m+adjc;
            if(ds.findUPar(nodeno) != ds.findUPar(adjNodeNo)){
              cnt--;
              ds.unionBySize(nodeno, adjNodeNo);
            }
          }
        }
      }
      ans.add(cnt);
    }
    return ans;
  }
}
