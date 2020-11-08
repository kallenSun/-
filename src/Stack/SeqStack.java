package Stack;

import java.util.Arrays;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2020/9/8 <br>
 * @since V9.0 <br>
 */
public class SeqStack<T> {
    private int length;
    private int top;
    private Object[] stack;
    private static double EXPANSION_FACTORY = 0.75;
    private static int DEFAULT_INITIAL_CAPACITY = 64;

    public SeqStack(int length) {
        if (length < DEFAULT_INITIAL_CAPACITY) {
            this.length = DEFAULT_INITIAL_CAPACITY;
        }
        this.stack = new Object[length];
        this.length = length;
        this.top = -1;
    }

    public SeqStack(){
        this(64);
    }

    // 判断栈为空
    public boolean isEmpty(){
        return this.top == -1;
    }

    // 入栈
    public void push(T t) {
        // 根据扩容因子进行扩容
        if (this.stack.length * EXPANSION_FACTORY == this.top) {
            expandCapacity(this.length);
        }
        this.stack[top+1] = t;
        this.top++;
        this.length++;
    }

    // 出栈
    public T pop(){
        if (isEmpty()) {
            return null;
        }
        T t = (T)this.stack[top];
        this.top--;
        this.length--;
        return t;
    }

    //扩大容量
    public void expandCapacity(int length) {
        int len = stack.length;
        length = length * 3 / 2 + 1;
        this.stack = Arrays.copyOf(stack, length);
    }
}
