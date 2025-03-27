package trees;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class zigzagLevelOrderTraversal {
  
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean rev = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                if (!rev) {
                    TreeNode currNode = queue.pollFirst();
                    currLevel.add(currNode.val);
                    if (currNode.left != null) {
                        queue.addLast(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.addLast(currNode.right);
                    }
                } else {
                    TreeNode currNode = queue.pollLast();
                    currLevel.add(currNode.val);
                    if (currNode.right != null) {
                        queue.addFirst(currNode.right);
                    }
                    if (currNode.left != null) {
                        queue.addFirst(currNode.left);
                    }
                }
            }
            rev = !rev;
            result.add(currLevel);
        }
        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        zigzagLevelOrderTraversal solution = new zigzagLevelOrderTraversal();

        // Constructing a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Expected output: [[1], [3, 2], [4, 5, 6, 7]]
        System.out.println(solution.zigzagLevelOrder(root));
    }
}
