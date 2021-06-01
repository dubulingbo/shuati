package leetcode.daily.y2020m10;

import leetcode.utils.beans.TreeNode;

import java.util.*;

/**
 * @author DubLBo
 * @since 2020-10-27 08:35
 * i believe i can i do
 */
public class D20201027_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
//        if(root == null) return list;


        // 法二：非递归
        Stack<TreeNode> stack = new Stack<>();
        if(root != null) stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);

            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }

        return list;
    }

    // 递归实现：二叉树的的前序遍历
    private void recur(TreeNode root, List<Integer> list){
        if(root == null) return;

        list.add(root.val);
        recur(root.left, list);
        recur(root.right, list);
    }
}
