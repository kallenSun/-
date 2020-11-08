package Tree;

/**
 * @author kallensun
 */
public class BinaryNode<T> {
    public T data;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T data,BinaryNode<T> left ,BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data) {
        this(data,null,null);
    }

    public BinaryNode() {
        this(null, null, null);
    }
}
