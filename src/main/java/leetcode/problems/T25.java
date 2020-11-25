package leetcode.problems;

import leetcode.utils.beans.ListNode;

public class T25 {
    // 25. K 个一组翻转链表
    // 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
    // k 是一个正整数，它的值小于或等于链表的长度。
    // 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
    public ListNode reverseKGroup(ListNode head, int k) {
        // 模拟
        if (k < 2) return head;
        // 结果链表的头结点
        ListNode dummyHead = new ListNode(999);
        // 结果链表的尾结点
        ListNode lastNode = dummyHead;
        // 指向前一个翻转位置
        ListNode keyNode = dummyHead;
        // 节点的序号，从 1 开始
        int rank = 1;
        while (head != null) {
            // 判断是否到 k个节点，若到了，就要翻转链表
            if (rank % k == 0) {
                ListNode nextNode = head.next;
                lastNode.next = head;
                // 封口很重要
                head.next = null;
                // 下一个 keyNode 的位置，即翻转后的链表的尾结点（null 的前一个）
                ListNode nextKeyNode = keyNode.next;
                // 翻转链表，再接上去
                keyNode.next = reverseList(keyNode.next);
                keyNode = nextKeyNode;
                lastNode = nextKeyNode;
                // 本次循环完，开始下一轮的循环
                rank = 1;
                head = nextNode;
                continue;
            }
            // 没到翻转时刻就直接将节点接到结果链表后面
            lastNode.next = head;
            lastNode = head;
            head = head.next;
            rank++;
        }

        return dummyHead.next;
    }

    // 翻转链表
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode t = head.next;
            head.next = prev;
            prev = head;
            head = t;
        }
        return prev;
    }
}
