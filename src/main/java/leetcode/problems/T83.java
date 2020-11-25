package leetcode.problems;

import leetcode.utils.beans.ListNode;

/**
 * @author DubLBo
 * @since 2020-11-10 18:08
 * i believe i can i do
 */
public class T83 {
    // 83. 删除排序链表中的重复元素
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
//        ListNode my = new ListNode(999);
//        my.next = head;
//        head = my;
        ListNode pre = head;
        ListNode cur = head.next;

        while(cur != null){
            if(pre.val == cur.val){
                //删除 cur 节点
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
