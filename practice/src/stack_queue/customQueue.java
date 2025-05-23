package stack_queue;

public class customQueue {
  protected int[] data;
  private static final int DEFAULT_SIZE=10;

  int end=0;

  public customQueue(){
    this(DEFAULT_SIZE);
  }

  public customQueue(int size){
    this.data=new int[size];
  }

  private boolean isFull(){
    return end==data.length; //ptr is at the last index
  }

  private boolean isEmpty(){
    return end==0;
  }

  public boolean insert(int item){
    if(isFull()){
      return false;
    }
    data[end++]=item;
    return true;
  }

  public int remove() throws Exception{
    if(isEmpty()){
      throw new Exception("Queue is empty");
    }

    int removed=data[0];

    //shift the elements to left
    for(int i=1;i<end;i++){
      data[i-1]=data[i];
    }
    end--;
    return removed;
  }

  public int front() throws Exception{
    if(isEmpty()){
      throw new Exception("Queue is empty");
    }
    return data[0];
  }

  public void display(){
    for(int i=0;i<end;i++){
      System.out.println(data[i]+" ");
    }
    System.out.println("END");
  }
}
