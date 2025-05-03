//DFS

package graph;
import java.util.*;
public class replaceOwithX {

  static void dfs(int row,int col, int vis[][],char mat[][],int[] delRow,int[] delCol){
    vis[row][col]=1;
    int n=mat.length;
    int m=mat[0].length;
    for(int i=0;i<4;i++){
      int nrow=row+delRow[i];
      int ncol=col+delCol[i];
      if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && mat[nrow][ncol]=='O'){
        dfs(nrow, ncol, vis, mat, delRow, delCol);
      }
    }
  }

  static char[][] fill(int n, int m, char[][] mat){
    int delRow[]={-1,0,1,0};
    int delCol[]={0,1,0,-1};
    int vis[][]=new int[n][m];

    //traverse the first row and last row
    for(int j=0;j<m;j++){
      //first row
      if(vis[0][j]==0 && mat[0][j]=='O'){
        dfs(0,j,vis,mat,delRow,delCol);
      }

      //last row
      if(vis[n-1][j]==0 && mat[n-1][j]=='O'){
        dfs(n-1,j,vis,mat,delRow,delCol);
      }
    }

    //traverse first and last column
    for(int i=0;i<n;i++){
      //first column
      if(vis[i][0]==0 && mat[i][0]=='O'){
        dfs(i,0,vis,mat,delRow,delCol);
      }

      //last column
      if(vis[i][m-1]==0 && mat[i][m-1]=='O'){
        dfs(i,m-1,vis,mat,delRow,delCol);
      }
    }

    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(vis[i][j]==0 && mat[i][j]=='O'){
          mat[i][j]='X';
        }
      }
    }
    return mat;
  }
}
