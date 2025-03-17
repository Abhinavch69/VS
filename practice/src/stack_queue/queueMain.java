package stack_queue;
import java.util.Queue;
public class queueMain {
  public static void main(String[] args) throws Exception{
    customQueue queue=new customQueue(5);
    queue.insert(3);
    queue.insert(5);
    queue.insert(7);
    queue.insert(9);
    queue.insert(11);

    queue.display();

    System.out.println("Removed element: "+queue.remove());

    queue.display();
  }
}
