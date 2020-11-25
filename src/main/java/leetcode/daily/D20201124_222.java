package leetcode.daily;

import leetcode.utils.beans.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class D20201124_222 {
    // 222. 完全二叉树的节点个数
    public int countNodes_bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int cnt = 0;
//        int depth = 0;
        if (root != null) queue.offer(root);

        while (!queue.isEmpty()) {
            // 上一层没达到，直接返回
            int size = queue.size();
            cnt += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null) {
                    return cnt + 2 * i;
                } else if (node.right == null) {
                    return cnt + 2 * i + 1;
                } else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
//            depth++;
        }
        return cnt;
    }

    private volatile int count = 0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return count;
    }


    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        count++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 31; i++) {
            System.out.println((int) Math.pow(2, i));
        }
    }
}
