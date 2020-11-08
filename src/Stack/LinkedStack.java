package Stack;

import Queue.LinkedQueue;

/**
 * <Description> <br>
 *
 * @author kallensun <br>
 * @CreateDate 2020/7/8 <br>
 * @since V9.0 <br>
 */
public class LinkedStack<T> {

    class Node<T>{

        private Node<T> next;

        private T data;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> top;
    private int length;

    public LinkedStack(){
        this.top = new Node<>(null);
        this.length = 0;
    }

    // 入栈
    public void push(T t) {
        if (t == null) {
            throw new NullPointerException("入栈参数不能为空");
        }
        if (this.top.data == null){
            this.top.data = t;
        }
        else {
            Node<T> temp = new Node<>(t);
            temp.next = top;
            this.top = temp;
        }
    }

    // 出栈
    public T pop() {
        if (this.length <= 0) {
            System.out.println("栈为空");
            return null;
        }
        T t = this.top.data;
        this.top = this.top.next;
        this.length--;
        return t;
    }
}
