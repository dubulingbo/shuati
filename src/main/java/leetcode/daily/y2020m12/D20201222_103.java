package leetcode.daily.y2020m12;

import leetcode.utils.beans.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author habitplus
 * @since 2020-12-22 12:54
 */
public class D20201222_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // BFS
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftStart = true;
        if (root != null) queue.offer(root);

        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (leftStart) list.addLast(node.val);
                else list.addFirst(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
            leftStart = !leftStart;
        }
        return res;
    }
}
