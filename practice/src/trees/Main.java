package trees;
import java.util.*;
public class Main {
  public static void main(String[] args) {
      //Scanner sc=new Scanner(System.in);
      //binaryTree tree=new binaryTree();
      //tree.populate(sc);
      //tree.display();
      //tree.prettyDisplay();

    //BST_insert tree=new BST_insert();
    //int[] nums={5,2,7,1,4,6,9,8,3,10};
    //tree.populate(nums);
    //tree.display();

    tree2AVL tree=new tree2AVL();

    for(int i=0;i<100;i++){
      tree.insert(i);
    }

    //System.out.println(tree.height());
  }
}
