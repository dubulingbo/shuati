package leetcode.problems;

import leetcode.utils.beans.ListNode;

/**
 * @author DubLBo
 * @since 2020-11-08 18:54
 * i believe i can i do
 */
public class T2 {
    // 2. 两数相加https://leetcode-cn.com/problems/add-two-numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        l1 = reverseList(l1);
//        l2 = reverseList(l2);
        ListNode my = new ListNode(999);
        ListNode ass = my;
        // 表示进位，也记录本次的计算结果
        int t = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                t += l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                t += l1.val;
                l1 = l1.next;
            } else {
                t += (l1.val + l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }
            ListNode node = new ListNode(t % 10);
            ass.next = node;
            ass = node;
            t = t / 10;
        }

        if(t != 0) {
            ListNode node = new ListNode(t);
            ass.next = node;
            ass = node;
        }

        return my.next;
    }

    /**
     * 原地翻转链表
     *
     * @param head 链表指针，指向第一个链表元素
     */
    private ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode ass;

        while (head.next != null) {
            ass = head.next;
            head.next = pre;
            pre = head;
            head = ass;
        }
        head.next = pre;
        return head;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node2.next = node4;
        node4.next = node3;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node5.next = node6;
        node6.next = node7;

        System.out.println(new T2().addTwoNumbers(node2, node5));
    }
}
