//DFS

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

public class diameterOfATree {
  public static void main(String[] args) {
      // Creating a sample binary tree
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      
      Solution solution = new Solution();
      int diameter = solution.diameterOfBinaryTree(root);
      System.out.println("Diameter of the Binary Tree: " + diameter);
  }
}

class Solution {
  int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
      height(root);
      return diameter - 1;
  }

  public int height(TreeNode node) {
      if (node == null) {
          return 0;
      }

      int leftHeight = height(node.left);
      int rightHeight = height(node.right);

      int dia = leftHeight + rightHeight + 1;
      diameter = Math.max(dia, diameter);

      return Math.max(leftHeight, rightHeight) + 1;
  }
}

