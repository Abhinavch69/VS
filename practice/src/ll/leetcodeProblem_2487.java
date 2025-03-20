import java.util.*;

class ListNode {
  int val;
  ListNode next;
  public ListNode(int val) {
      this.val = val;
      this.next = null;
  }
}

public class leetcodeProblem_2487 {

  public ListNode removeNodes(ListNode head) {
    Stack<ListNode> stack=new Stack<>();
    ListNode temp=head;
    while(temp!=null){
      while(!stack.isEmpty() && stack.peek().val<temp.val){
        stack.pop();
      }
      stack.push(temp);
      temp=temp.next;
    }

    ListNode newnode=null;
    while(!stack.isEmpty()){
      ListNode node=stack.pop();
      node.next=newnode;
      newnode=node;
    }
    return newnode;
  }

  public static void printList(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
        System.out.print(temp.val + " -> ");
        temp = temp.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(5);
    head.next = new ListNode(3);
    head.next.next = new ListNode(8);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(10);

    System.out.println("Original List:");
    printList(head);

    leetcodeProblem_2487 obj = new leetcodeProblem_2487();
    head = obj.removeNodes(head);

    System.out.println("List after removing next greater elements:");
    printList(head);
  }
  
}