package trees;

  import java.util.*;

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
  
  class Solution {
      public boolean isSymmetric(TreeNode root) {
          if (root == null) return true;
          
          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root.left);
          queue.add(root.right);
          
          while (!queue.isEmpty()) {
              TreeNode left = queue.poll();
              TreeNode right = queue.poll();
              
              if (left == null && right == null) continue;
              if (left == null || right == null) return false;
              if (left.val != right.val) return false;
              
              queue.add(left.left);
              queue.add(right.right);
              queue.add(left.right);
              queue.add(right.left);
          }
          return true;
      }
  }
  
  public class symmetricTree {  // Class name corrected to PascalCase
      public static void main(String[] args) {
          Solution solution = new Solution();
  
          // Test Case 1: Symmetric Tree
          TreeNode symmetricRoot = new TreeNode(1,
                  new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                  new TreeNode(2, new TreeNode(4), new TreeNode(3))
          );
          System.out.println("Is Symmetric? " + solution.isSymmetric(symmetricRoot)); // Output: true
  
          // Test Case 2: Asymmetric Tree
          TreeNode asymmetricRoot = new TreeNode(1,
                  new TreeNode(2, null, new TreeNode(3)),
                  new TreeNode(2, null, new TreeNode(3))
          );
          System.out.println("Is Symmetric? " + solution.isSymmetric(asymmetricRoot)); // Output: false
      }
  }
  