package trees;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  
  TreeNode(int val) {
      this.val = val;
  }
  
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}

public class invertBinaryTree {
  public static void main(String[] args) {
      // Creating a sample binary tree
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
      root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));
      
      Solution solution = new Solution();
      TreeNode invertedRoot = solution.invertTree(root);
      
      System.out.println("Inverted Binary Tree Root: " + invertedRoot.val);
  }
}

class Solution {
  public TreeNode invertTree(TreeNode root) {
      if (root == null)
          return null;

      TreeNode left = invertTree(root.left);
      TreeNode right = invertTree(root.right);

      root.left = right;
      root.right = left;

      return root;
  }
}
