package stack_queue;
import java.util.*;
public class usingDS {
  public static void main(String[] args) {

    //Stack using classes
    /* 
    Stack<Integer> s = new Stack<>();
    s.push(10);
    s.push(20);
    s.push(30);
    System.out.println("Stack: " + s);
    System.out.println("Top element: " + s.peek());
    System.out.println("Popped element: " + s.pop());
    */

    //Queue using classes
    /*  
    Queue<Integer> queue=new LinkedList<>();
    queue.add(10);
    queue.add(20);
    queue.add(30);
    System.out.println("Queue: " + queue);
    System.out.println("Front element: " + queue.peek());
    System.out.println("Removed element: " + queue.remove());
    System.out.println(queue);
    */

    //Dequeue
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(10);
    deque.addLast(20);
    deque.addFirst(30);
    System.out.println(deque);
    deque.removeFirst();
    System.out.println(deque);
    //etc etc
  }
}
