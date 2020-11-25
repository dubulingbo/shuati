package leetcode.icci;

import leetcode.utils.beans.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author DubLBo
 * @since 2020-11-02 21:36
 * i believe i can i do
 */
public class T17_12 {
    // 存储前一个节点
    private TreeNode pre;
    private TreeNode head;
    private List<TreeNode> list;

    public TreeNode convertBiNode01(TreeNode root) {
//        // 二叉搜索树的中序遍历 + 列表遍历
        list = new ArrayList<>();
        pre = null;
        head = new TreeNode(999);
        recur(root);

        if (list.size() == 0) return null;
        int len = list.size();
        TreeNode res = list.get(0);

        for (int i = 1; i < len; i++) {
            list.get(i - 1).right = list.get(i);
            list.get(i - 1).left = null;
        }
        list.get(len - 1).left = null;
        list.get(len - 1).right = null;
        return res;

//        if(root == null) return null;
//        Stack<TreeNode> stack = new Stack<>();
//
//        stack.push(root);
//        while(root.left != null){
//            stack.push(root.left);
//            root = root.left;
//        }
//
//        List<TreeNode> list = new ArrayList<>();
//
//        while(!stack.isEmpty()){
//            TreeNode node = stack.pop();
//            list.add(node);
////            if(node.right)
//            while(node.left != null){
//                stack.push(node.left);
//                node = node.left;
//            }
//
//        }
    }

    private void recur01(TreeNode root) {
        if (root == null) return;
        // 先遍历左子树，找到第一个最左端的结点
        if (root.left != null) recur01(root.left);
        list.add(root);
        if (root.right != null) recur01(root.right);
    }

    private void recur(TreeNode root) {
        if (root == null) return;
        // 先遍历左子树，找到第一个最左端的结点
        if (root.left != null) recur(root.left);
        if (pre == null) {
            // 当前位第一个节点
            pre = root;
            head.right = root;
        } else {
            pre.right = root;
            pre = root;
        }
        root.left = null;
        if (root.right != null) recur(root.right);
    }

    public TreeNode convertBiNode(TreeNode root) {
        // 二叉搜索树的中序遍历 + 原地修改地址
        pre = null;
        head = new TreeNode(999);
        recur(root);
        return head.right;
    }

    public TreeNode convertBiNode_NonRecur(TreeNode root) {
        // 单链表的头指针
        TreeNode head = new TreeNode(999);
        // 移动的链表前置指针
        TreeNode prev = head;
        // 开始中序遍历
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                // ---链表处理
                // 当前节点左指针置空
                node.left = null;
                // 前置指针右指针指向当前节点，作为链表的next指针，链表新增元素
                prev.right = node;
                // 指针后移
                prev = node;

                // 中序遍历进入右子树
                node = node.right;
            }
        }
        return head.right;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;
        n1.left = n0;
        n5.right = n6;

        System.out.println(new T17_12().convertBiNode_NonRecur(n4));
//        TreeNode n1 = new TreeNode(0);
//        TreeNode n1 = new TreeNode(0);
    }
}
