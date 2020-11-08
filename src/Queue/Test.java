package Queue;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2020/11/7 <br>
 * @since V9.0 <br>
 */
public class Test {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 12; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(queue.pop());
        }

    }
}
