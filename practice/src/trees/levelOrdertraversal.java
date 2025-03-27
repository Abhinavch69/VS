package trees;

import java.util.*;
import java.util.Queue;

public class levelOrdertraversal {
  public static void main(String[] args) {
    
  }

  public List<List<Integer>> levelOrder(TreeNode root){
    List<List<Integer>> result=new ArrayList<>();

    if(root==null){
      return result;
    }

    Queue<TreeNode> queue=new LinkedList<>();

    queue.offer(root);
    while(!queue.isEmpty()){
      int levelSize=queue.size();
      List<Integer> currlevel=new ArrayList<>();
      for(int i=0;i<levelSize;i++){
        TreeNode currNode=queue.poll();
        currlevel.add(currNode.val);
        if(currNode.left!=null){
          queue.offer(currNode.left);
        }
        if(currNode.right!=null){
          queue.offer(currNode.right);
        }
      }
      result.add(currlevel);
    }
    return result;
  }
}
