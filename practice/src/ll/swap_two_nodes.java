package ll;
import java.lang.classfile.components.ClassPrinter.ListNode;
import java.util.*;
public class swap_two_nodes {

  private class ListNode{
    private int value;
    private ListNode next;

    public ListNode(int value){
      this.value = value;
    }

    public ListNode(int value, ListNode next){
      this.value = value;
      this.next = next;
    }
  }
  private ListNode head;
  private ListNode tail;
 
  public void insertFirst(int val) {
    ListNode node = new ListNode(val);
    node.next = head;
    head = node;

    if (tail == null) {
        tail = head;
    }
}

  public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode point=dummy;
        
        while(point.next!=null && point.next.next!=null){
            ListNode swap1=point.next;
            ListNode swap2=point.next.next;

            swap1.next=swap2.next;
            swap2.next=swap1;

            point.next=swap2;
            point=swap1;
        }
        return dummy.next;
    }

    public static void display(ListNode head) {
      ListNode temp = head;
      while (temp != null) {
          System.out.print(temp.value + " -> ");
          temp = temp.next;
      }
      System.out.println("null");
  }

    public static void main(String[] args) {
      swap_two_nodes l1=new swap_two_nodes();
      l1.insertFirst(1);
      l1.insertFirst(2);
      l1.insertFirst(3);
      l1.insertFirst(4);

      System.out.println("Original list");
      l1.display(l1.head);

      l1.head=l1.swapPairs(l1.head);
      System.out.println("List after swapping");
      l1.display(l1.head);

    }
}
