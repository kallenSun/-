package Queue;

/**
 * <Description> 循环队列<br>
 *
 * @author kallensun <br>
 * @CreateDate 2020/09/7 <br>
 */
public class SeqQueue<T> {

    private static int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    private Object[] queue;

    private int count;

    private int length;

    private int front;

    private int rear;

    // 默认创建数组长度12
    public SeqQueue(int length){
        if (length < DEFAULT_INITIAL_CAPACITY){
            this.length = DEFAULT_INITIAL_CAPACITY;
        }
        this.queue = new Object[length];
        this.length = length;
        this.front = this.rear = 0;
    }

    public SeqQueue(){
        this(64);
    }

    // 判断队列是否为满
    public boolean isFull(){
        return (rear+1) % length == front;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return this.front == this.rear;
    }

    // 入队列,采用循环队列的方式
    public void push(T t) {
        if (t == null){
            System.out.println("入列对象不能为空");
            return;
        }
        if (this.isFull()) {
            System.out.println("队列已满");
            return;
        }
        this.rear = (this.rear + 1) % this.length;
        this.queue[this.rear] = t;
        this.count++;
    }

    // 出队列，先入先出
    public void pop(){
        if (this.isEmpty()){
            System.out.println("队列为空");
            return;
        }
        this.front = (this.front + 1) % this.length;
    }

    // 取队头元素
    public T getFront(){
        if (this.isEmpty()) {
            System.out.println("队列为空");
            return null;
        }
        return (T) this.queue[(front + 1) % length];
    }


}
