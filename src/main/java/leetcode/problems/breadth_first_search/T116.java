package leetcode.problems.breadth_first_search;

import leetcode.utils.beans.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-11-05 16:59
 * i believe i can i do
 */
public class T116 {
    // 116. 填充每个节点的下一个右侧节点指针
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        Node pre = null;
        int k;
        while (!queue.isEmpty()) {
            k = queue.size();
            for (int i = 0; i < k; i++) {
                Node node = queue.poll();
                if (i != 0) {
                    pre.next = node;
                }
                pre = node;

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }

}
