//cousins in binary tree
//two node are cousins if they are on same level and does not have same parent

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

class leetcode_problem_993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return ((level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy)));
    }

    public TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x)
            return node;

        TreeNode n = findNode(node.left, x);
        if (n != null) {
            return n;
        }
        return findNode(node.right, x);
    }

    boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null)
            return false;

        return ((node.left == x && node.right == y) || (node.left == y && node.right == x) || isSibling(node.left, x, y)
                || isSibling(node.right, x, y));
    }

    int level(TreeNode node, TreeNode x, int lev) {
        if (node == null)
            return 0;

        if (node == x) {
            return lev;
        }

        int l = level(node.left, x, lev + 1);
        if (l != 0) {
            return l;
        }
        return level(node.right, x, lev + 1);
    }

    // Driver method to test isCousins function
    public static void main(String[] args) {
      leetcode_problem_993 solution = new leetcode_problem_993();

        // Constructing a sample binary tree:
        //         1
        //        / \
        //       2   3
        //      /     \
        //     4       5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        int x = 4, y = 5;
        boolean result = solution.isCousins(root, x, y);
        System.out.println("Are nodes " + x + " and " + y + " cousins? " + result);
    }
}
