package trees;
import java.util.*;
public class binaryTree {

  public binaryTree(){

  }

  private static class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
      this.value=value;
    }
  }

  private Node root;

  //insert elements
  public void populate(Scanner sc){
    System.out.println("Enter the root Node: ");
    int value = sc.nextInt();
    root=new Node(value);
    populate(sc,root);
  }

  private void populate(Scanner sc,Node node){
    System.out.println("Do you want to enter left of "+node.value);
    boolean left=sc.nextBoolean();
    if(left){
      System.out.println("Enter the value of the left of "+node.value);
      int value=sc.nextInt();
      node.left=new Node(value);
      populate(sc, node.left);
    }

    System.out.println("Do you want to enter right of "+node.value);
    boolean right=sc.nextBoolean();
    if(right){
      System.out.println("Enter the value of the right of "+node.value);
      int value=sc.nextInt();
      node.right=new Node(value);
      populate(sc, node.right);
    }
  }

  public void display(){
    display(root,"");
  }

  public void display(Node node,String indent){
    if(node==null) return;

    System.out.println(indent+node.value);
    display(node.left,indent+"\t");
    display(node.right,indent+"\t");
  }

  public void prettyDisplay(){
    prettyDisplay(root,0);
  }

  private void prettyDisplay(Node node,int level){
    if(node==null) return;

    prettyDisplay(node.right, level+1);

    if(level!=0){
      for(int i=0;i<level-1;i++){
        System.out.print("|\t\t");
      }
      System.out.println("|------->"+node.value);
    }else{
      System.out.println(node.value);
    }

    prettyDisplay(node.left, level+1);
  }

  public void preOrder(){
    preOrder(root);
  }

  private void preOrder(Node node){
    if(node==null) return;

    System.out.println(node.value+" ");
    preOrder(node.left);
    preOrder(node.right);
  }

  public void inOrder(){
    inOrder(root);
  }

  private void inOrder(Node node){
    if(node==null) return;

    preOrder(node.left);
    System.out.println(node.value+" ");
    preOrder(node.right);
  }

  public void postOrder(){
    postOrder(root);
  }

  private void postOrder(Node node){
    if(node==null) return;

    preOrder(node.left);
    preOrder(node.right);
    System.out.println(node.value+" ");
  }

}
