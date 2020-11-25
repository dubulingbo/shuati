package leetcode.problems;

import leetcode.utils.beans.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-11-13 11:14
 * i believe i can i do
 */
public class T111 {

    public int minDepth(TreeNode root) {
        // 广度优先搜索 BFS
        Queue<TreeNode> queue = new LinkedList<>();
        int min = 0;

        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    //已经找到最近的叶子节点了
                    return min + 1;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            // 遍历完一层，min + 1
            min++;
        }
        return min;
    }
}
