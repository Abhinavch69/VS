//Topological sort wala kaam hi h bs BFS ka use krti h
import java.util.*;
public class kahn_Algo {
  static int[] topoSort(int V,List<List<Integer>> adj){
    int inDegree[]=new int[V];
    for(int i=0;i<V;i++){
      for(int it:adj.get(i)){
        inDegree[it]++;
      }
    }
    Queue<Integer> q=new LinkedList<>();
    for(int i=0;i<V;i++){
      if(inDegree[i]==0){
        q.add(i);
      }
    }
    int topo[]=new int[V];
    int i=0;
    while(!q.isEmpty()){
      int node=q.peek();
      q.remove();
      topo[i++]=node;
      //node is in your topo sort
      //so please remove it from the inDegree

      for(int it:adj.get(node)){
        inDegree[it]--;
        if(inDegree[it]==0){
          q.add(it);
        }
      }
    }
    return topo;
  }
}
