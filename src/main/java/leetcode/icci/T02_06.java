package leetcode.icci;

import leetcode.utils.beans.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-10-22 15:55
 * i believe i can i do
 */
public class T02_06 {

    // 编写一个函数，检查输入的链表是否是回文的。
    public boolean isPalindrome(ListNode head) {
        // 辅助列表法
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }

        int len = nodes.size();
        for (int i = 0; i < len / 2; i++) {
            if (nodes.get(i).val != nodes.get(len - i - 1).val) {
                return false;
            }
        }
        return true;
    }
}
