package leetcode.icci;

import leetcode.utils.beans.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-10-22 14:45
 * i believe i can i do
 */
public class T02_04 {

    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;

        List<ListNode> list = new ArrayList<>();
        ListNode assist = head;
        while(assist != null){
            list.add(head);
            assist = assist.next;
        }


//        int len = ;
        int i = 0, j = list.size() - 1;
        while(i<j){
            // 找到首个结点的值 >=x 的结点
            while(i<j && list.get(i).val < x) i++;
            // 找到最后一个结点 <x 的结点
            while(i<j && list.get(j).val >= x) j--;

            // 交换 i 和 j 结点
            if(i != j){
                ListNode p = list.get(i);
                ListNode q = list.get(j);
                int tmp = p.val;
                p.val = q.val;
                q.val = tmp;
            }
        }

        return head;

    }

}
