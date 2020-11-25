package leetcode.problems;

import leetcode.utils.beans.TreeNode;

public class T235 {
    // 235. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 二叉搜索树为空，直接返回 null
        if (root == null) return null;

        if (root.val > p.val && root.val > q.val) {
            // p、q 都在 左子树上
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            // p、q 都在 右子树上
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // p、q 位于左右子树上，最近的祖先就是 root
            // p、q 其中一个就是 root，最近的祖先就是 root
            return root;
        }
    }
}
