package Tree;

import java.util.Arrays;


/**
 * @author kallensun
 */
public class BinaryTree<T> {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(new Integer[]{3, 9, 20, 15, 7}, new Integer[]{9, 3, 15, 20, 7});
        binaryTree.preorderTravel(binaryTree.root);
    }

    public BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    /**
     * 从先序列和中序列中构造二叉树
     */
    public BinaryTree(T[] preorder, T[] inorder) {
       this.root = buildTree(preorder,inorder);
    }

    public BinaryNode<T> buildTree(T[] preorder, T[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        BinaryNode<T> root = new BinaryNode<>(preorder[0]);
        for (int i = 0; i < preorder.length; ++i) {
            if (preorder[0] == inorder[i]) {
                T[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                T[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                T[] inLeft= Arrays.copyOfRange(inorder, 0, i);
                T[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(preLeft,inLeft);
                root.right = buildTree(preRight,inRight);
                break;
            }
        }
        return root;
    }

    public void preorderTravel(BinaryNode<T> root){
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorderTravel(root.left);
        preorderTravel(root.right);
    }
}

