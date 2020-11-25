package leetcode.icof;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-10-20 22:15
 * i believe i can i do
 */
public class T035 {



    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> randMap = new HashMap<>();
        HashMap<Node, Node> newOldMap = new HashMap<>();
        List<Node> list = new LinkedList<>();

        Node newHead = new Node(0);
        Node  newAssist = newHead;

        Node assist = head;
        // 建立 新链表的 next 指针
        while(assist != null){
//            list.add(assist);
            Node node = new Node(assist.val);
            newAssist.next = node;
            newOldMap.put(assist, node);
            assist = assist.next;
            newAssist = node;
        }

        // 建立 新链表的 rand 指针
        newAssist = newHead.next;
        while(head != null){
            if(head.random != null){
                newAssist.random = newOldMap.get(head.random);
            }
            head = head.next;
            newAssist = newAssist.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        T035 t = new T035();
        Node copyListNode = t.copyRandomList(n1);

        System.out.println(copyListNode.toString());

    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
