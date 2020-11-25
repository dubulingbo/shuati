package leetcode.icci;

import leetcode.utils.beans.ListNode;
import leetcode.utils.beans.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-10-23 13:48
 * i believe i can i do
 */
public class T04_03 {

    public ListNode[] listOfDepth(TreeNode tree) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        List<ListNode> ans = new ArrayList<>();
        // 创建多余的空头结点，便于链表创建
        ListNode dummy = new ListNode(0);

        if(tree != null){
            queue.offer(tree);
        }

        while (!queue.isEmpty()) {

            ListNode curr = dummy;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode treeNode = queue.poll();
                curr.next = new ListNode(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                curr = curr.next;
            }
            ans.add(dummy.next);
            // 为下个回合的链表构建做准备
            dummy.next = null;
        }

        return ans.toArray(new ListNode[] {});
    }
}
