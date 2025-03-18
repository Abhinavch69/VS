public class ll {

  private Node head;
  private Node tail;
  private int size;
  public ll(){
    this.size=0;
  }

  public void insertFirst(int val){
    Node node=new Node(val);
    node.next=head;
    head=node;

    if(tail == null){
      tail=head;
    }

    size++;
  }

  public void insertLast(int val){
    if(tail == null){
      insertFirst(val);
      return;
    }

    Node node=new Node(val);
    tail.next=node;
    tail=node;
    size++;
  }

  public void insert(int val, int index){
    if(index==0){
      insertFirst(val);
      return;
    }
    if(index==size){
      insertLast(val);
      return;
    }

    Node temp=head;
    for(int i=1;i<index;i++){
      temp=temp.next;
    }

    Node node=new Node(val, temp.next);
    temp.next=node;
    size++;
  }

  //insert using recursion
  public void insertRec(int val, int index){
    head=insertRec(val, index, head);
  }

  private Node insertRec(int val, int index, Node node){
    if(index==0){
      Node temp = new Node(val,node);
      size++;
      return temp;
    }
    node.next = insertRec(val, index--, node.next);
    return node;
  }

  public int deleteFirst(){
    int val=head.value;
    head=head.next;
    if(head == null){
      tail = null;
    }
    size--;
    return val;
  }

  public int deleteLast(){
    if(size <= 1){
      return deleteFirst();
    }

    Node secondLast=get(size-2);
    int val=tail.value;
    tail=secondLast;
    tail.next=null;
    return val;
  }

  public int delete(int index){
    if(index==0){
      return deleteFirst();
    }

    if(index == size-1){
      return deleteLast();
    }

    Node prev = get(index-1);
    int val=prev.next.value;
    prev.next=prev.next.next;
    return val;
  }

  public Node find(int value){
    Node node=head;
    while(node!=null){
      if(node.value == value){
        return node;
      }
      node=node.next;
    }
    return null;
  }

  public Node get(int index){
    Node node=head;
    for(int i=0;i<index;i++){
      node=node.next;
    }
    return node;
  }

  public void display(){
    Node temp=head;
    while(temp!=null){
      System.out.print(temp.value+" -> ");
      temp=temp.next;
    }
    System.out.println("END");
  }

  private class Node{
    private int value;
    private Node next;

    public Node(int value){
      this.value = value;
    }

    public Node(int value, Node next){
      this.value = value;
      this.next = next;
    }
  }

  //QUESTIONS
  // 1. REMOVE DUPLICATES FROM A SORTED LINKED LIST
  public void duplicates(){
    Node node=head;
    while(node.next!=null){
      if(node.value == node.next.value){
        node.next=node.next.next;
        size--;
      }else{
        node=node.next;
      }
    }
    tail=node;
    tail.next=null;
  }

  // 2. MERGE TWO SORTED LIST
  public static ll merge(ll first, ll second){
    Node f=first.head;
    Node s=second.head;

    ll ans=new ll();
    while(f!=null && s!=null){
      if(f.value < s.value){
        ans.insertLast(f.value);
        f=f.next;
      }else{
        ans.insertLast(s.value);
      }
    }
    while(f!=null){
      ans.insertLast(f.value);
      f=f.next;
    }
    while(s!=null){
      ans.insertLast(s.value);
      s=s.next;
    }
    return ans;
  }

  // 3. DETECT CYCLE IN LINKED LIST
  // USING SLOW FAST METHOD 
  // AMAZON AND MICROSOFT
  public boolean hasCycle(){
    Node fast=head;
    Node slow=head;
      while(fast!=null && fast.next!=null){
          fast=fast.next.next;
          slow=slow.next;
          if(fast == slow){
              return true;
          }
      }
    return false;
  }

  public int lengthOfCycle(Node head){
    Node fast=head;
    Node slow=head;
    int length=0;
      while(fast!=null && fast.next!=null){
          fast=fast.next.next;
          slow=slow.next;
          if(fast == slow){
              //calculate the length
              Node temp=slow;
              do{
                temp=temp.next;
                length++;
              }while(temp!=slow);

              return length;
          }
      }
    return 0;
  }

  //find the starting node of the cycle
  public Node findFirstNodeOfCycle(Node head){
    int length=0;

    Node fast=head;
    Node slow=head;

    while(fast!=null && fast.next!=null){
      fast=fast.next.next;
      slow=slow.next;
      if(fast == slow){
          length=lengthOfCycle(slow);
          break;
        }
    }
    if(length==0) return null;
    //find the start node
    Node f=head;
    Node s=head;
    while(length>0){
      s=s.next;
      length--;
    }

    //keep moving both forward and they will meet at cycle start
    while(f!=s){
      s=s.next;
      f=f.next;
    }
    return s;
  }

  //GOOGLE
  //HAPPY NUMBER
  //ALSO USES SLOW AND FSAT POINTER APPROACH
  public boolean isHappy(int n) {
       int slow=n;
       int fast=n;

       do{
        slow=findSquare(slow);
        fast=findSquare(findSquare(fast));
       }while(fast!=slow);
       if(slow==1) return true;
       return false;
  }

  private int findSquare(int number){
    int ans=0;
    while(number>0){
      int rem=number%10;
      ans+=rem*rem;
      number/=10;
    }
    return ans;
  }
  //END

  //MIDDLE OF LINKED LIST
  public Node middleNode(Node head) {
    Node f=head;
    Node s=head;
    while(f!=null && f.next!=null){
        s=s.next;
        f=f.next.next;
    }
    return s;
}
//END
  public static void main(String[] args) {
    ll first = new ll();
    ll second = new ll();

    first.insertLast(1);
    first.insertLast(5);
    first.insertLast(7);
    first.insertLast(9);
    first.insertLast(10);

    second.insertLast(1);
    second.insertLast(4);
    second.insertLast(6);
    second.insertLast(8);
    
    ll ans=ll.merge(first, second);
    ans.display();
  }
}