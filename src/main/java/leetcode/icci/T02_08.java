package leetcode.icci;

import leetcode.utils.beans.ListNode;

import java.util.HashSet;

/**
 * @author DubLBo
 * @since 2020-10-22 19:09
 * i believe i can i do
 */
public class T02_08 {
    // 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
    // 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hash = new HashSet<>();
        ListNode assist = head;
        while (assist != null) {
            hash.add(assist);
            if (hash.contains(assist.next)) {
                return assist.next;
            }
            assist = assist.next;
        }
        return null;
    }
}
