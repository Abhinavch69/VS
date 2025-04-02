package trees;

class TreeNode {
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

class Solution {
    int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k).val;
    }

    public TreeNode helper(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = helper(root.left, k);
        if (left != null) return left;

        count++;
        if (count == k) return root;

        return helper(root.right, k);
    }
}

public class kthSmallestElement {
    public static void main(String[] args) {
        // Create a BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        Solution solution = new Solution();

        // Test case 1: 3rd smallest element (should be 3)
        solution.count = 0; // Reset count before each test
        int k = 3;
        int result = solution.kthSmallest(root, k);
        System.out.println("The " + k + "rd smallest element is: " + result);

        // Test case 2: 1st smallest element (should be 1)
        solution.count = 0;
        k = 1;
        result = solution.kthSmallest(root, k);
        System.out.println("The " + k + "st smallest element is: " + result);

        // Test case 3: 5th smallest element (should be 5)
        solution.count = 0;
        k = 5;
        result = solution.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);

        // Test case 4: 6th smallest element (should be 6)
        solution.count = 0;
        k = 6;
        result = solution.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }
}