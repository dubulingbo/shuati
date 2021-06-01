package leetcode.daily.y2020m11;

import leetcode.utils.beans.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author DubLBo
 * @since 2020-11-20 12:11
 * i believe i can i do
 */
public class D20201120_147 {
    // 147. 对链表进行插入排序
    public ListNode insertionSortList01(ListNode head) {
        if (head == null || head.next == null) return head;
        // 有序链表的头结点
        ListNode mySorted = new ListNode(999);
        ListNode cur = head.next;
        mySorted.next = head;
        head.next = null;
        while (cur != null) {
            // 将当前的 cur 指向的节点插入到 sorted list 中
            ListNode tmp = cur.next;
            ListNode ass = mySorted;
            while (ass.next != null) {
                // 找到了插入位置，头插法
                if (cur.val <= ass.next.val) {
                    cur.next = ass.next;
                    ass.next = cur;
                    break;
                }
                ass = ass.next;
            }
            // 说明遍历到了尾部还是没有找到合适的位置，那就在尾部直接插入
            if (ass.next == null) {
                cur.next = null;
                ass.next = cur;
            }
            cur = tmp;
        }
        return mySorted.next;
    }

    public ListNode insertionSortList02(ListNode head) {
        // 堆排序 + 二次遍历
        PriorityQueue<ListNode> sortedList = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        while (head != null) {
            sortedList.offer(head);
            head = head.next;
        }

        ListNode dummyHead = new ListNode(999);
        ListNode ass = dummyHead;
        while (!sortedList.isEmpty()) {
            ListNode node = sortedList.poll();
            ass.next = node;
            node.next = null;
            ass = node;
        }

        return dummyHead.next;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 找到中间节点
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        // 这里是将前半部分链表截断
        prev.next = null;

        // 分别对 前后两部分链表进行排序
        ListNode left = insertionSortList(head);
        ListNode right = insertionSortList(slow);

        // 合并 左右两部分已经有序的链表
        head = merge(left, right);
        return head;
    }

    // 合并两个有序的链表
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyHead = new ListNode(999);
        ListNode ass = dummyHead;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                ass.next = node2;
                break;
            } else if (node2 == null) {
                ass.next = node1;
                break;
            } else {
                if (node1.val > node2.val) {
                    ass.next = node2;
                    ass = node2;
                    node2 = node2.next;
                } else {
                    ass.next = node1;
                    ass = node1;
                    node1 = node1.next;
                }
            }
        }
        return dummyHead.next;
    }

    private ListNode merge01(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
