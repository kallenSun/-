package Tree.BinarySearchTree;


import java.util.ArrayList;
import java.util.List;


/**
 /**
 * <Description> 二叉搜索树也称二叉排序树 <br>
 *     特点:某个节点，若其有两个子节点，则一定满足，左子节点值一定小于该节点值，右子节点值一定大于该节点值 <br>
 * @author kallensun <br>
 * @CreateDate 2021/7/26 <br>
 */
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        super();
    }

    /**
     * 插入节点
     * @param data 要插入的值
     */
    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        if (root.data >= data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (node.data >= data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    /**
     * 下面是遍历，和普通的二叉树一样
     */
    // 前序
    public List<Integer> preOrderTraversal() {
        return preOrderTraversal(root);
    }

    private List<Integer> preOrderTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.data);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }

    // 中序
    public List<Integer>  inorderTraversal() {
        return inorderTraversal(root);
    }

    private List<Integer> inorderTraversal(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        inorder(node.left, res);
        res.add(node.data);
        inorder(node.right, res);
    }

    // 后序
    public List<Integer> postOrderTraversal() {
        return postOrderTraversal(root);
    }

    private List<Integer> postOrderTraversal(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        postOrder(node, res);
        return res;
    }

    private void postOrder(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        postOrder(node.right, res);
        res.add(node.data);
        postOrder(node.left, res);
    }

    /**
     * 查找给定值
     */
    public Node find(int value) {
        Node node = find(root, value);
        return node;
    }

    private Node find(Node node, int value) {
        Node cur = node;
        if (cur == null) {
            return null;
        }

        while (cur != null) {
            if (cur.data == value) {
                return cur;
            } else if (cur.data > value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    /**
     * 删除节点，
     * @param value
     */
    public void delete(int value) {

    }

    /**
     * 找到指定节点下的最小值
     * @param node
     * @return
     */
    public Node findMinNode(Node node) {
        Node cur = node;
        if (cur == null) {
            return null;
        }
        while (cur != null) {
            if (cur.left == null) {
                return cur;
            } else {
                cur = cur.left;
            }
        }
        return cur;
    }
}
