package leetcode.daily.y2020m11;

import leetcode.utils.beans.ListNode;

/**
 * @author DubLBo
 * @since 2020-11-21 00:04
 * i believe i can i do
 */
public class D20201121_148 {
    // 148. 排序链表
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 寻找 中间节点 mid （快慢指针）
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        // 这里 是将 左链表的尾部 置空
        slow.next = null;

        // 排序 左右链表
        ListNode leftList = sortList(head);
        ListNode rightList = sortList(fast);

        // 合并 左右链表
        return merge(leftList, rightList);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(999);
        ListNode ass = dummyHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                ass.next = l2;
                break;
            } else if (l2 == null) {
                ass.next = l1;
                break;
            } else {
                if (l1.val > l2.val) {
                    ass.next = l2;
                    ass = l2;
                    l2 = l2.next;
                } else {
                    ass.next = l1;
                    ass = l1;
                    l1 = l1.next;
                }
            }
        }
        return dummyHead.next;
    }
}
