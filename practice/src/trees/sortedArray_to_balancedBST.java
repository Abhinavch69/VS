package trees;

import java.util.*;



class sortedArray_to_balancedBST {
  class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
  }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end)
            return null;
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
    private static void printLevelOrder(TreeNode root) {
      if (root == null) return;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      
      while (!queue.isEmpty()) {
          TreeNode node = queue.poll();
          System.out.print(node.val + " ");
          if (node.left != null) queue.add(node.left);
          if (node.right != null) queue.add(node.right);
      }
    }
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the size of sorted array:");
      int n = scanner.nextInt();
      int[] nums = new int[n];
      
      System.out.println("Enter sorted array elements:");
      for (int i = 0; i < n; i++) {
          nums[i] = scanner.nextInt();
      }
      
      sortedArray_to_balancedBST solution = new sortedArray_to_balancedBST();
      TreeNode root = solution.sortedArrayToBST(nums);
      
      System.out.println("Level Order Traversal of BST:");
      printLevelOrder(root);
      
      scanner.close();
    }
}

