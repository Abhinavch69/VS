//find MST
//disjoint set
import java.util.*;
class Edge implements Comparable<Edge>{
  int src,dest,weight;
  Edge(int s,int d,int w){
    src=s;dest=d;weight=w;
  }
  //Comparator function used for
  //sorting edgebased on their weight
  public int compareTo(Edge compareEdge){
    return this.weight - compareEdge.weight;
  }
};
public class kruskal_Algo {
  static int spanningTree(int V,List<List<List<Integer>>> adj){
    List<Edge> edges=new ArrayList<>();
    //O(N + E)
    for(int i=0;i<V;i++){
      for(int j=0;j<adj.get(i).size();j++){
        int adjNode=adj.get(i).get(j).get(0);
        int wt=adj.get(i).get(j).get(1);
        int node=i;
        Edge temp=new Edge(i,adjNode,wt);
        edges.add(temp);
      }
    }
    disjoint_Set ds=new disjoint_Set(V);
    //M log M
    Collections.sort(edges);
    int mstWt=0;
    // M x 4 x alpha x 2
    for(int i=0;i<edges.size();i++){
      int wt=edges.get(i).weight;
      int u=edges.get(i).src;
      int v=edges.get(i).dest;

      if(ds.findUPar(u) != ds.findUPar(v)){
        mstWt+=wt;
        ds.unionBySize(u, v);
      }
    }
    return mstWt;
  }
}
