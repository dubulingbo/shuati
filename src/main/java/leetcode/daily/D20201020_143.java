package leetcode.daily;

import java.util.Stack;

/**
 * @author DubLBo
 * @since 2020-10-20 11:08
 * i believe i can i do
 */
public class D20201020_143 {
    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode() { }

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        // 两次单链表遍历 + 辅助栈
        ListNode assistPtr = head;
        int len = 0;
        Stack<ListNode> stack = new Stack<>();
        // 统计结点总数，并将各结点压栈
        while (assistPtr != null) {
            len++;
            stack.push(assistPtr);
            assistPtr = assistPtr.next;
        }

        if (len <= 2) return;

        assistPtr = head;
        len /= 2;
        while (len > 0) { // 至少要有三个节点才循环
            ListNode node = stack.pop();
//            ListNode copyNode = new ListNode(node.val, node.next);
            node.next = assistPtr.next;
            assistPtr.next = node;
            len--;
            assistPtr = node.next;
        }
        assistPtr.next = null;
    }

}
