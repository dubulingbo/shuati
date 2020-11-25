package leetcode.icof;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-10-16 13:34
 * i believe i can i do
 */
public class T055I {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int maxDepth_bfs(TreeNode root) {
            // BFS
            Queue<TreeNode> queue = new LinkedList<>();
            int depth = 0;

            if (root != null) queue.add(root);

            while (!queue.isEmpty()) {

                for (int i = queue.size(); i > 0; i--) {
                    // 将本层的所有节点都出队
                    TreeNode node = queue.poll();
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                // 层数加一
                depth++;
            }
            return depth;
        }

        public int maxDepth(TreeNode root) {
            // DFS
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
