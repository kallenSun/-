package Tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Tree.TreeNode;


/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2021/12/29 <br>
 * @since V9.0 <br>
 */
public class Test {

    public static void main(String[] args) {
//        BinarySearchTree bst = new BinarySearchTree();
//        bst.insert(4);
//        bst.insert(2);
//        bst.insert(1);
//        bst.insert(3);
//        bst.insert(5);
//        List<Integer> res = bst.preOrderTraversal();
//        System.out.println("前序遍历:");
//        for (int i = 0; i < res.size(); i++) {
//            System.out.print(res.get(i));
//        }
//        System.out.println(" ");
//
//        res = bst.inorderTraversal();
//        System.out.println("中序遍历:");
//        for (Integer i : res) {
//            System.out.print(i);
//        }
//        System.out.println("");
//
//        res = bst.postOrderTraversal();
//        System.out.println("后序遍历:");
//        for (Integer i : res) {
//            System.out.print(i);
//        }
//        System.out.println("");
//
//        Node node = bst.find(3);
//        if (node != null) {
//            System.out.println("find result is:" + node.data);
//        } else {
//            System.out.println("can't find result");
//        }
//        System.out.println("----------------------");
//        node = bst.find(7);
//        if (node != null) {
//            System.out.println("find result is:" + node.data);
//        } else {
//            System.out.println("can't find result");
//        }
//
//        Node node1 = new Node();
//        System.out.println("dsaf"+node1.hashCode());




    }

    public static List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> first = new LinkedList<>();
        LinkedList<TreeNode> second = new LinkedList<>();
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        first.add(root);
        while (first.size() != 0 || second.size() != 0) {
            while (first.size() != 0) {
                TreeNode node = first.poll();
                if (node.val > firstMax) {
                    firstMax = node.val;
                }
                if (node.left != null) {
                    second.addLast(node.left);
                }
                if (node.right != null) {
                    second.add(node.right);
                }
                if (first.size() == 0) {
                    res.add(firstMax);
                    firstMax = Integer.MIN_VALUE;
                }
            }

            while (second.size() != 0) {
                TreeNode node = second.poll();
                if (node.val > secondMax) {
                    secondMax = node.val;
                }
                if (node.left != null) {
                    first.addLast(node.left);
                }
                if (node.right != null) {
                    first.add(node.right);
                }
                if (second.size() == 0) {
                    res.add(secondMax);
                    secondMax = Integer.MIN_VALUE;
                }
            }
        }
        return res;
    }


}
