//use of dijoint set
import java.util.*;
public class numberOfProvices_DisjointSet {
    static int numProvinces(List<List<Integer>> adj,int V){
      disjoint_Set ds=new disjoint_Set(V);
      for(int i=0;i<V;i++){
        for(int j=0;j<V;j++){
          if(adj.get(i).get(j)==1){
            //edge between i and j
            ds.unionBySize(i, j);
          }
        }
      }
      int cnt=0;
      for(int i=0;i<V;i++){
        if(ds.parent.get(i)==i) cnt++;
      }
      return cnt;
    }
}
