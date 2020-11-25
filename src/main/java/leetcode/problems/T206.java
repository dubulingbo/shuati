package leetcode.problems;

import leetcode.utils.beans.ListNode;

/**
 * @author DubLBo
 * @since 2020-11-13 21:51
 * i believe i can i do
 */
public class T206 {
    // 206. 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode last;
        while(head != null){
            last = head.next;
            head.next = prev;
            prev = head;
            head = last;
        }
        return prev;
    }
}
