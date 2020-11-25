package leetcode.icof;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-10-20 13:24
 * i believe i can i do
 */
public class T037 {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.add(null);
            }
        }
        return res.toString();
    }

    // 总结： BFS 双层循环要比单层循环快！！！
    public TreeNode deserialize(String data) {
        if (!data.startsWith("[") || !data.endsWith("]")) {
            return null;
        }
        String sample = data.substring(1, data.length() - 1);
        if (sample.equals("") || sample.startsWith("null")) {
            return null;
        }

        String[] array = sample.split(", ");

        TreeNode head = new TreeNode(Integer.parseInt(array[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int k = 1;
        while (!queue.isEmpty() && k < array.length) {
//            for (int i = queue.size(); i > 0 && k < array.length; i++, k += 2) {
            TreeNode node = queue.poll();
            // 判断左结点
            if (!array[k].equals("null") && !array[k].equals("")) {
                TreeNode tmp = new TreeNode(Integer.parseInt(array[k]));
                node.left = tmp;
                queue.add(tmp);
            }

            // 判断右结点
            if (!array[k + 1].equals("null") && !array[k + 1].equals("")) {
                TreeNode tmp = new TreeNode(Integer.parseInt(array[k + 1]));
                node.right = tmp;
                queue.add(tmp);
            }

            k += 2;
//            }
        }
        return head;
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
//        res.add(null);
//        res.add(2);
//        res.add(3);
//        res.add(null);
//        res.add(null);
//        res.add(4);
//        res.add(5);
        String s = "[1,2,3,null,null,4,5]";

        TreeNode head = new T037().deserialize(s);


        System.out.println(res.toString());
    }
}
