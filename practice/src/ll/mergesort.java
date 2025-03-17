import java.lang.classfile.components.ClassPrinter.ListNode;

public class mergesort {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    
    // Split the list into two halves.
    ListNode mid = getMid(head);
    ListNode left = sortList(head);
    ListNode right = sortList(mid);
    
    return mergeTwoLists(left, right);
}

private ListNode getMid(ListNode head) {
    ListNode prev = null;
    ListNode slow = head;
    ListNode fast = head;
    
    // Move slow by 1 and fast by 2 steps.
    while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    
    // Disconnect the left half from the right half.
    if (prev != null) {
        prev.next = null;
    }
    
    return slow;
}

public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    
    while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            tail.next = list1;
            list1 = list1.next;
        } else {
            tail.next = list2;
            list2 = list2.next;
        }
        tail = tail.next;
    }
    
    tail.next = (list1 != null) ? list1 : list2;
    return dummy.next;
}
 //RECURSION REVERSE OF LL
private void reverseList(Node node){
  if(node==tail){
    haed=tail;
    return;
  }

  reverse(node.next);

  tail.node=node;
  tail=node;
  tail.next=null;
}

//inplace reversing of linked list
public ListNode reverse(ListNode head){
    if(head==null) return head;
    ListNode prev=null;
    ListNode present = head;
    ListNode next=present.next;

    while(present!=null){
        present.next=prev;
        prev=present;
        present=next;
        if(next!=null){
            next=next.next;
        }
    }
    head=prev;
    return head;
}
//reverse linked list 2 ...problem number 92
public ListNode reverseBetween(ListNode head, int left, int right) {
    if(left==right) return head;

    //skip the first left-1 nodes
    ListNode current=head;
    ListNode prev=null;
    for(int i=0;current!=null && i<left-1;i++){
        prev=current;
        current=current.next;
        ListNode last=prev;
        ListNode newEnd=current;

        //reverse between left and right
        ListNode next=current.next;
        for(int i=0;current!=null && i<right-left+1;i++){
            current.next=prev;
            prev=current;
            cuurent=next;
            if(next!=null){
                next=next.next;
            }
        }
        if(last!=null){
            last.next=prev;
        }
        else{
            head=prev;
        }
        newEnd.next=current;
        return head;
    }
}

//PALINDROME LINKED LIST
public boolean isPalindrome(ListNode head) {
    ListNode mid=getMid(head);
    ListNode headSecond=reverse(mid);
    ListNode rereverseHead=headSecond;
    
    //comapre both the halves
    while(head!=null && headSecond!=null){
        if(head.val!=headSecond.val) break;
        head=head.next;
        headSecond=headSecond.next;
    }
    reverse(rereverseHead);

    return head==null || headSecond==null;
}
//GOOGLE FACEBOOK
//REORDER LIST ...PROBLEM NO. 143
public void reorderList(ListNode head) {
    if(head==null || head,next==null) return;

    ListNode mid=getMid(head);
    ListNode hs=reverse(mid);
    ListNode hf=head;
    while(hs!=null && hs!=null){
        ListNode temp=hf.next;
        hf.next=hs;
        hf=temp;

        temp=hs.next;
        hs.next=hf;
        hs=temp;
    } 

    //next to tail to null
    if(hf!=null){
        hf.next=null;
    }
}

//problem no 25
//amazon facebook

public ListNode reverseKGroup(ListNode head, int k) {
    
}
}

