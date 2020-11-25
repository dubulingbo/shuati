package leetcode.icof;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author DubLBo
 * @since 2020-10-19 13:27
 * i believe i can i do
 */
public class T068II {
    // 题目描述：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//        if (root.val == p.val || root.val == q.val) {
//            return root;
//        }
//        boolean pOnLeft = isTreeOfNode(root.left, p);
//        boolean qOnRight = isTreeOfNode(root.right, q);
//        boolean pOnRight = isTreeOfNode(root.right, p);
//        boolean qOnLeft = isTreeOfNode(root.left, q);
//
//        if (pOnLeft && qOnLeft) {
//            // 都在左子树上
//            return lowestCommonAncestor(root.left, p, q);
//        } else if (pOnRight && qOnRight) {
//            // 都在右子树上
//            return lowestCommonAncestor(root.right, p, q);
//        } else {
//            // p 在 root 的左子树上，q 在 root 的右子树上
//            // p 在 root 的右子树上，q 在 root 的左子树上
//           return root;
//        }

        // 优化1：
//        if (root.val == p.val || root.val == q.val) {
//            return root;
//        }
//        boolean pOnLeft = isTreeOfNode(root.left, p);
//        boolean qOnLeft = isTreeOfNode(root.left, q);
//
//        if(pOnLeft){ // p 在左子树上
//            return qOnLeft ? lowestCommonAncestor(root.left, p, q) : root;
//        } else { // p 在右子树上
//            return qOnLeft ? root : lowestCommonAncestor(root.right, p, q);
//        }
        // 优化2：换成循环
//        while (root != null) {
//            if (root.val == p.val || root.val == q.val) {
//                break;
//            }
//            boolean pOnLeft = isTreeOfNode(root.left, p);
//            boolean qOnRight = isTreeOfNode(root.left, q);
//
//            if (pOnLeft && !qOnRight) { // p 在左子树上
//                root = root.left;
//            } else if (!pOnLeft && qOnRight) { // p 在右子树上
//                root = root.right;
//            } else {
//                break;
//            }
//        }
//        return root;

        // 优化三：本身递归
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left == null){ // p,q 都不在 root 的左子树上
            return right;
        }

        if(right == null){ // p,q 都不在 root 的右子树上
            return left;
        }

        // root 就是 p,q 的最近公共祖先结点
        return root;
    }

    // 根据 node的val 判断是不是 tree 上的结点
    private boolean isTreeOfNode(TreeNode tree, TreeNode node) {
        if (tree == null) {
            return false;
        }


        if (tree.val == node.val) {
            return true;
        }

        return isTreeOfNode(tree.left, node) || isTreeOfNode(tree.right, node);


    }


}
