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

public class BT_to_LL {
  public static void flatten(TreeNode root){
    if(root == null) return;

    TreeNode curr=root;
    while(curr!=null){
      if(curr.left!=null){
        TreeNode temp=curr.left;
        while(temp.right!=null){
          temp=temp.right;
        }
        temp.right=curr.right;
        curr.right=curr.left;
        curr.left=null;
      }
      curr=curr.right;
    }
  }

  public static void preorderPrint(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val + " ");
    preorderPrint(root.left);
    preorderPrint(root.right);
  }

  public static void printFlattenedTree(TreeNode root) {
    while (root != null) {
        System.out.print(root.val + " ");
        root = root.right;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // Creating a sample binary tree
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(6);

    Solution solution = new Solution();
    System.out.println("Original Tree (Preorder Traversal):");
    preorderPrint(root);
    
    // Flattening the tree
    flatten(root);
    
    System.out.println("\nFlattened Tree (Right-Skewed List):");
    printFlattenedTree(root);
  }

}
