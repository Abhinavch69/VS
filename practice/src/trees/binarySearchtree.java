package trees;

public class binarySearchtree {
  class Node{
    private int value;
    private int height;
    private Node left;
    private Node right;

    public Node(int value){
      this.value = value;
    }

    public int getValue(){
      return value;
    }
  }
    private Node root;
  

    public binarySearchtree(){

    }

    public int height(Node node){
      if(node==null) return -1;
      return node.height;
    }

    public boolean isEmpty(){
      return root==null;
    }

    public void display(){
      display(root,"Root node: ");
    }

    private void display(Node node,String details){
      if(node==null){
        return;
      }
      System.out.println(details+node.getValue());

      display(node.left, "left child of "+node.getValue()+" : ");
      display(node.right, "right child of "+node.getValue()+" : ");
    }
  
}
