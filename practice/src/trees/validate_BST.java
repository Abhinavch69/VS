package trees;

class TreeNode {
  int val;
  TreeNode left, right;
  
  TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
  }
}

class Solution {
  public boolean isValidBST(TreeNode root) {
      return f(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  
  private boolean f(TreeNode root, long low, long high) {
      if (root == null) return true;
      if (root.val >= high || root.val <= low) return false;
      return f(root.left, low, root.val) && f(root.right, root.val, high);
  }
}

public class validate_BST {
  public static void main(String[] args) {
      // Constructing a sample valid BST
      TreeNode root = new TreeNode(2);
      root.left = new TreeNode(1);
      root.right = new TreeNode(3);
      
      Solution solution = new Solution();
      System.out.println("Is valid BST: " + solution.isValidBST(root)); // Expected output: true

      // Constructing an invalid BST
      TreeNode root2 = new TreeNode(5);
      root2.left = new TreeNode(1);
      root2.right = new TreeNode(4);
      root2.right.left = new TreeNode(3);
      root2.right.right = new TreeNode(6);
      
      System.out.println("Is valid BST: " + solution.isValidBST(root2)); // Expected output: false
  }
}
