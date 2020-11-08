package Queue;


/**
 * @author sunyue <br>
 */
public class LinkedQueue<T> {
    class Node<T>{

        private Node<T> next;

        private T data;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;

    private Node<T> rear;

    private int length;

    public LinkedQueue(){
        this.front = new Node<T>(null);
        this.rear = front;
        this.length = 0;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return this.length == 0;
    }

    // 入队列
    public void push(T t){
        Node<T> temp = new Node<>(t);
        this.rear.next = temp;
        this.rear = temp;
        this.length++;
    }

    // 出队列
    public T pop(){
        if (this.length <= 0) {
            System.out.println("队列为空");
            return null;
        }
        T value = this.front.next.data;
        this.front = this.front.next;
        this.length--;
        return  value;
    }


}
