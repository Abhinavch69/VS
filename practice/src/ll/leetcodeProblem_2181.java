class ListNode {
  int val;
  ListNode next;
  public ListNode(int val) {
      this.val = val;
      this.next = null;
  }
}

class leetcodeProblem_2181 {
  public ListNode mergeNodes(ListNode head) {
      if (head == null) return head;

      ListNode p1 = head;
      while (p1.next != null) {
          ListNode p2 = p1.next;
          int sum = 0;
          while (p2.val != 0) {
              sum += p2.val;
              p2 = p2.next;
          }
          if (p2.next == null) {
              p1.val = sum;
              p1.next = null;
          } else {
              p1.val = sum;
              p1.next = p2;
              p1 = p2;
          }
      }
      return head;
  }

  // Helper method to print the linked list
  public static void printList(ListNode head) {
      ListNode temp = head;
      while (temp != null) {
          System.out.print(temp.val + " -> ");
          temp = temp.next;
      }
      System.out.println("null");
  }

  public static void main(String[] args) {
      // Creating the input linked list: 0 -> 3 -> 1 -> 0 -> 4 -> 5 -> 2 -> 0 -> null
      ListNode head = new ListNode(0);
      head.next = new ListNode(3);
      head.next.next = new ListNode(1);
      head.next.next.next = new ListNode(0);
      head.next.next.next.next = new ListNode(4);
      head.next.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next.next = new ListNode(2);
      head.next.next.next.next.next.next.next = new ListNode(0);

      System.out.println("Original List:");
      printList(head);

      leetcodeProblem_2181 obj = new leetcodeProblem_2181();
      head = obj.mergeNodes(head);

      System.out.println("Merged List:");
      printList(head);
  }
}
