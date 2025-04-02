//LCA = Lowest Common Ancestor

package trees;

public class LCA_of_twoNodes {
  public TreeNode LCA(TreeNode root, TreeNode p,TreeNode q){
    if(root==null) return null;

    if(root==p || root== q){
      return root;
    }

    TreeNode left=LCA(root.left, p, q);
    TreeNode right=LCA(root.right, p, q);

    if(left!=null && right!=null){
      return root;
    }
    return left==null?right:left;
  }
    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Test case 1: Nodes 5 and 1 (LCA should be 3)
        TreeNode p = root.left;  // Node 5
        TreeNode q = root.right; // Node 1
        TreeNode lca = new LCA_of_twoNodes().LCA(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is " + lca.val);

        // Test case 2: Nodes 5 and 4 (LCA should be 5)
        p = root.left;          // Node 5
        q = root.left.right.right; // Node 4
        lca = new LCA_of_twoNodes().LCA(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is " + lca.val);

        // Test case 3: Nodes 6 and 4 (LCA should be 5)
        p = root.left.left;     // Node 6
        q = root.left.right.right; // Node 4
        lca = new LCA_of_twoNodes().LCA(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is " + lca.val);

        // Test case 4: Nodes 7 and 8 (LCA should be 3)
        p = root.left.right.left;  // Node 7
        q = root.right.right;       // Node 8
        lca = new LCA_of_twoNodes().LCA(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is " + lca.val);
    }

}
