//minimum number of edges to require to coonect different components of a graph


package graph;
import java.util.*;
public class connectingTheGraph {
  public int solve(int n,int[][] edge){
    disjoint_Set ds=new disjoint_Set(n);
    int cntExtras=0;
    int m=edge.length;
    for(int i=0;i<m;i++){
      int u=edge[i][0];
      int v=edge[i][1];
      if(ds.findUPar(u)==ds.findUPar(v)){
        cntExtras++;
      }else{
        ds.unionBySize(u, v);
      }
    }
    int cntC=0;
    for(int i=0;i<n;i++){
      if(ds.parent.get(i)==i) cntC++;
    }
    int ans=cntC-1;
    if(cntExtras>=ans) return ans;
    return -1;
  }
}
