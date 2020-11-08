package Stack;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2020/11/8 <br>
 * @since V9.0 <br>
 */
public class Test {
    public static void main(String[] args) {
        SeqStack<Integer> seqStack = new SeqStack<>();
        for (int i = 0; i < 20; i++) {
            seqStack.push(i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(seqStack.pop());
        }
    }
}
