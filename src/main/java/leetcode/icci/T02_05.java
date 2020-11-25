package leetcode.icci;

import leetcode.utils.beans.ListNode;

/**
 * @author DubLBo
 * @since 2020-10-22 15:27
 * i believe i can i do
 */
public class T02_05 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int digit = 0; // 表示向高位的进位
        ListNode head = new ListNode(0);
        ListNode assist = head;
        while (l1 != null || l2 != null || digit != 0) {
            int s1 = l1 != null ? l1.val : 0;
            int s2 = l2 != null ? l2.val : 0;
            int sum = s1 + s2 + digit;

            ListNode node = new ListNode(sum % 10);
            digit = sum / 10;
            assist.next = node;
            assist = node;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return head.next;
    }
}
