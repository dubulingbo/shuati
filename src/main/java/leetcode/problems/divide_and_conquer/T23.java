package leetcode.problems.divide_and_conquer;

import leetcode.utils.beans.ListNode;

/**
 * @author DubLBo
 * @since 2020-11-04 16:28
 * i believe i can i do
 */
public class T23 {
    // 23. 合并K个升序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int left = 0;
        int right = lists.length - 1;
        return mergeLists(lists, left, right);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left > right) return null;
        if (left == right) return lists[left];

        // 这里是将区间完全拆成两部分，即 [left,mid] 和 [mid+1,right]；
        // 但不能是 [left,mid-1] [mid,right]，因为 mid-1 可能会越界
        int mid = left + (right - left) / 2;
        ListNode leftList = mergeLists(lists, left, mid);
        ListNode rightList = mergeLists(lists, mid+1, right);
        return merge(leftList, rightList);
    }

    private ListNode merge(ListNode node1, ListNode node2) {

        ListNode head = new ListNode();
        ListNode p = head;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                p.next = node2;
                node2 = node2.next;
            } else if (node2 == null) {
                p.next = node1;
                node1 = node1.next;
            } else {
                if (node1.val > node2.val) {
                    p.next = node2;
                    node2 = node2.next;
                } else {
                    p.next = node1;
                    node1 = node1.next;
                }
            }
            p = p.next;
        }
        return head.next;
    }
}
