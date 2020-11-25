package leetcode.problems.breadth_first_search;

import leetcode.utils.beans.TreeNode;

import java.util.*;

/**
 * @author DubLBo
 * @since 2020-11-05 16:39
 * i believe i can i do
 */
public class T107 {
    // 107. 二叉树的层次遍历 II
    // 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> tmpList = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmpList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(0, tmpList);
        }

        // 翻转列表
//        Collections.reverse(res);
        return res;
    }
}
