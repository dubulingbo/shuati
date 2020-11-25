package leetcode.problems;

import leetcode.utils.beans.TreeNode;

/**
 * @author DubLBo
 * @since 2020-11-13 10:02
 * i believe i can i do
 */
public class T108 {
    // 108. 将有序数组转换为二叉搜索树
    // 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
    // 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
    public TreeNode sortedArrayToBST(int[] nums) {
        // 注意到本题的数组是有序的，所以可以使用二分法来建立二叉搜索树
//        int left = 0, right = nums.length - 1;
        return createBST(nums, 0 , nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int left, int right){
        if(left > right) return null;
        if(left == right) return new TreeNode(nums[left]);

        int mid = left + (right - left) / 2;
        // 当前的【中间结点】就是【接下来要创建的平衡二叉树的根节点】
        TreeNode root = new TreeNode(nums[mid]);
        // 递归构造 root 的左子树
        root.left = createBST(nums, left,mid - 1);
        // 递归构造 root 的右子树
        root.right = createBST(nums, mid + 1, right);

        return root;
    }
}
