package trees;
import java.util.*;
public class findinfRightSuccessor {
  public static void main(String[] args) {
    
  }

  public TreeNode findSuccessor(TreeNode root, int key){

    if(root==null){
      return null;
    }

    Queue<TreeNode> queue=new LinkedList<>();

    queue.offer(root);
    while(!queue.isEmpty()){
        TreeNode currNode=queue.poll();
        if(currNode.left!=null){
          queue.offer(currNode.left);
        }
        if(currNode.right!=null){
          queue.offer(currNode.right);
        }
        if(currNode.val==key){
          break;
        }
    }
    return queue.peek();
  }
}
