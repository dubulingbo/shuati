package leetcode.icof;

import java.util.ArrayList;

/**
 * @author DubLBo
 * @since 2020-10-20 15:42
 * i believe i can i do
 */
public class T036 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    private ArrayList<Node> list;
    public Node treeToDoublyList(Node root) {
        // 递归中序遍历 + 列表
        if(root == null){
            return null;
        }

        list = new ArrayList<>();
        inorder(root);

        Node head = list.get(0), pre = head;
        for(int i=1;i< list.size();i++){
            Node next = list.get(i);
            pre.right = next;
            next.left = pre;
            pre = next;
        }
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void inorder(Node node){
        // 二叉树的中序遍历
        if(node == null) return;

        if(node.left != null) inorder(node.left);

        // 当前node 进队列
        list.add(node);

        if(node.right != null) inorder(node.right);
    }
}
