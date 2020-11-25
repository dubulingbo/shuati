package leetcode.icof;

/**
 * @author DubLBo
 * @since 2020-10-19 13:27
 * i believe i can i do
 */
public class T068I {
    // 题目描述：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 二叉搜索树：二叉查找树：二叉排序树
    // 要么是一个空树
    // 要么是满足下列性质的二叉树：
    //      1. 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
    //      2. 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
    //      3. 它的左、右子树也分别为二叉排序树。
    //      4. 节点的键值唯一（自己定义的）
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                // 两个节点都在左子树上
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                // 两个节点都在右子树上
                root = root.right;
            } else {
                // 两个节点一左一右；那当前节点就是最近的公共祖先节点
                // 有一个节点是 root ，那当前节点也是它俩最近的公共祖先节点
                break;
            }
        }
        return root;
    }
}
