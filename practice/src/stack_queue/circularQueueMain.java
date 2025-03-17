package stack_queue;

public class circularQueueMain {
  public static void main(String[] args) throws Exception {
    circularQueue queue=new circularQueue(5);
    queue.insert(3);
    queue.insert(6);
    queue.insert(7);
    queue.insert(9);
    
    queue.display();

    System.out.println(queue.remove());

    queue.display();
  }
}
