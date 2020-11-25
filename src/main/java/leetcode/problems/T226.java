package leetcode.problems;

import leetcode.utils.beans.TreeNode;

/**
 * @author DubLBo
 * @since 2020-11-19 15:28
 * i believe i can i do
 */
public class T226 {
    //
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 反转左子树
        TreeNode left = invertTree(root.left);
        // 反转右子树
        TreeNode right = invertTree(root.right);
        // 交换 root 下面的左右结点
        root.left = right;
        root.right = left;
        return root;
    }




}
