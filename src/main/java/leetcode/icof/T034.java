package leetcode.icof;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-10-20 18:39
 * i believe i can i do
 */
public class T034 {
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

    private List<List<Integer>> res;
    private LinkedList<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // 回溯法：dfs + 路径存储（List）
        res = new ArrayList<>();
        path = new LinkedList<>();

        dfs(root, sum);

        return res;

    }

    private void dfs(TreeNode node, int target) {
        if (node == null) return;

        target -= node.val;
        path.add(node.val);

        // 路径和为target，其当前 node 为叶子结点
        if (target == 0 && node.left == null && node.right == null) {
            // 这里需要 new 一片新的空间，实现深拷贝
            res.add(new ArrayList<>(path));
        }

        dfs(node.left, target);
        dfs(node.right, target);

        // 这里的target 不需要加回来，因为 target采用的是值传递，上层递归的 target 的值并不会改变
        path.removeLast();
    }
}
