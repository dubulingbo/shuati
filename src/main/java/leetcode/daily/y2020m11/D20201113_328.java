package leetcode.daily.y2020m11;

import leetcode.utils.beans.ListNode;

import java.util.List;

/**
 * @author DubLBo
 * @since 2020-11-13 09:03
 * i believe i can i do
 */
public class D20201113_328 {
    // 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
    // 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
    // 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
    public ListNode oddEvenList(ListNode head) {
        ListNode evenPtr = new ListNode(998);
        ListNode oddPtr = new ListNode(999);
        ListNode ePtr = evenPtr;
        ListNode oPtr = oddPtr;
        boolean isOdd = true;
        while(head != null){
            if(isOdd){
                oPtr.next = head;
                oPtr = head;
            } else {
                ePtr.next = head;
                ePtr = head;
            }
            head = head.next;
            isOdd = !isOdd;
        }
        // 偶数指针需要对后面的尾部进行处理
        ePtr.next = null;
        // 将偶数链表连接到奇数链表的后面
        oPtr.next = evenPtr.next;

        return oddPtr.next;
    }
}
