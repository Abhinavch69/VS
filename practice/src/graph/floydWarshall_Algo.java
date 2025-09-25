//multi source shortest path algo(hr node se hr node tk smallest distace find krta h)
//helps to detect negative cycle as well
//using something that is pre computed
//if the costing to travel from a node to the node itself is less than zero then we can say it's a negative cycle
import java.util.*;
public class floydWarshall_Algo {
  public void shortest_distance(int[][] matrix){
    int n=matrix.length;
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(matrix[i][j]==-1){
          matrix[i][j]=(int)(1e9);
        }
        if(i==j) matrix[i][j]=0;
      }
    }
    //N x N x N
    for(int k=0;k<n;k++){
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
        }
      }
    }

    //for negative cycle
    for(int i=0;i<n;i++){
      if(matrix[i][i]<0){
        //print something here
      }
    }

    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(matrix[i][j]==(int)(1e9)){
          matrix[i][j]=-1;
        }
      }
    }
  }
}
