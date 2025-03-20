


class ListNode {
  int val;
  ListNode next;

  public ListNode(int val) {
      this.val = val;
      this.next = null;
  }

  public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
  }
}

public class leetcodeProblem_203 {
  public static void main(String[] args) {
      // Creating the linked list: 1 -> 2 -> 6 -> 3 -> 6 -> 5 -> null
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(6);
      head.next.next.next = new ListNode(3);
      head.next.next.next.next = new ListNode(6);
      head.next.next.next.next.next = new ListNode(5);

      System.out.println("Original List:");
      printList(head);

      // Removing all occurrences of 6
      head = removeElements(head, 6);

      System.out.println("List after removing 6:");
      printList(head);
  }

  public static ListNode removeElements(ListNode head, int val) {
      while (head != null && head.val == val) {
          head = head.next;
      }

      if (head == null) return null;

      ListNode prev = head;
      ListNode temp = head.next;

      while (temp != null) {
          if (temp.val == val) {
              prev.next = temp.next;
          } else {
              prev = temp;
          }
          temp = temp.next;
      }

      return head;
  }

  public static void printList(ListNode head) {
      ListNode temp = head;
      while (temp != null) {
          System.out.print(temp.val + " -> ");
          temp = temp.next;
      }
      System.out.println("null");
  }
}
