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

class rightSideView {
    public List<Integer> rightSide(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                // Capture the rightmost node of each level
                if (i == levelSize - 1) {
                    result.add(currNode.val);
                }

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }
        return result;
    }

    // Driver method to test the rightSideView function
    public static void main(String[] args) {
        rightSideView solution = new rightSideView();

        // Constructing a sample binary tree:
        //         1
        //        / \
        //       2   3
        //        \   \
        //         5   4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Get the right-side view of the tree
        List<Integer> rightView = solution.rightSide(root);

        // Print the result
        System.out.println("Right Side View: " + rightView);
    }
}
