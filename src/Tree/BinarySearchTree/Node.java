package Tree.BinarySearchTree;

/**
 * <Description> 二叉搜索树也称二叉排序树 <br>
 *     特点:某个节点，若其有两个子节点，则一定满足，左子节点值一定小于该节点值，右子节点值一定大于该节点值 <br>
 * @author kallensun <br>
 * @CreateDate 2021/7/26 <br>
 */
public class Node {
    public Node left;
    public Node right;
    public int data;

    public Node() {}

    public Node(int data) {
        this.data = data;
    }

    public Node(Node left, Node right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}

