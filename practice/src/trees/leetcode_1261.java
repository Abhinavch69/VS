/*Given a binary tree with the following rules:

1. root.val == 0
2.For any treeNode:
If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
3. If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

Implement the FindElements class:

FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it.
bool find(int target) Returns true if the target value exists in the recovered binary tree. */

package trees;

import javax.swing.tree.TreeNode;

public class leetcode_1261 {

  public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
     TreeNode root;
   public leetcode_1261(TreeNode root) {
        this.root=root;
        root.val=0;
        dfs(root);
    }

    private void dfs(TreeNode root){
      if(root==null){
        return;
      }
      int x=root.val;

      //update left node value if present
      if(root.left!=null) root.left.val=2*x+1;

      //update right node value if present
      if(root.right!=null) root.right.val=2*x+2;

      //go to left
      dfs(root.left);

      //go to right
      dfs(root.right);
    }
    
    public boolean find(int target) {
        return find(root,target);
    }

    private boolean find(TreeNode root, int target){
      if(root==null){
        return false;
      }

      if(root.val==target){
        return true;
      }

      //try to find on the left / right of thre current node
      return find(root.left,target) || find(root.right,target);
    }
}
