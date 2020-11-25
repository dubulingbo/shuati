package leetcode.utils.beans;

/**
 * @author DubLBo
 * @since 2020-10-22 14:47
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int x) { val = x; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
