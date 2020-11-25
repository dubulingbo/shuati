package leetcode.problems;

import leetcode.utils.beans.TreeNode;

/**
 * @author DubLBo
 * @since 2020-11-13 09:49
 * i believe i can i do
 */
public class T112 {
    // 112. 路径总和
    // 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    // 说明: 叶子节点是指没有子节点的节点。
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        // 路径和为零，且已经到了叶子结点
        if(sum - root.val == 0 && root.left == null && root.right == null) return true;
        // 继续遍历左右子树，并且只要有一个满足条件就可以结束了
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
