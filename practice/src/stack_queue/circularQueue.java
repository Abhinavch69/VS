package stack_queue;

public class circularQueue {
  protected int[] data;
  private static final int DEFAULT_SIZE=10;

  protected int end=0;
  protected int front=0;
  private int size=0;

  public circularQueue(){
    this(DEFAULT_SIZE);
  }

  public circularQueue(int size){
    this.data=new int[size];
  }

  private boolean isFull(){
    return size==data.length; //ptr is at the last index
  }

  private boolean isEmpty(){
    return size==0;
  }

  public boolean insert(int item){
    if(isFull()){
      return false;
    }
    data[end++]=item;
    end=end%10;
    size++;
    return true;
  }

  public int remove() throws Exception{
    if(isEmpty()){
      throw new Exception("Queue is empty");
    }

    int removed=data[front++];
    front=front%data.length;
    size--;
    return removed;
  }

  public int front() throws Exception{
    if(isEmpty()){
      throw new Exception("Queue is empty");
    }
    return data[front];
  }

  public void display(){
    int i=front;
    do{
      System.out.print(data[i]+ " -> ");
      i++;
      i%=data.length;
    }while(i!=end);
    System.out.println("END");
}
}
