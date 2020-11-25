package leetcode.problems;

import leetcode.utils.beans.Node;
import leetcode.utils.beans.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T257 {
    // 257. 二叉树的所有路径
    public List<String> binaryTreePaths_bfs(TreeNode root) {
        // BFS
        List<String> resList = new ArrayList<>();
        Queue<NodeInf> queue = new LinkedList<>();

        if (root != null) queue.offer(new NodeInf(root, "" + root.val));

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                NodeInf inf = queue.poll();
                if (inf.node.left == null && inf.node.right == null) {
                    resList.add(inf.path);
                    continue;
                }
                if (inf.node.left != null) {
                    queue.offer(new NodeInf(inf.node.left, inf.path + "->" + inf.node.left.val));
                }
                if (inf.node.right != null) {
                    queue.offer(new NodeInf(inf.node.right, inf.path + "->" + inf.node.right.val));
                }
            }
        }
        return resList;
    }

    static class NodeInf {
        // 当前节点
        public TreeNode node;
        // 存储到当前节点的路径
        public String path;

        public NodeInf(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resList = new ArrayList<>();
        dfs(root, "", resList);
        return resList;
    }

    private void dfs(TreeNode root, String s, List<String> resList) {
        if (root == null) return;

        String path = s.equals("") ? s + root.val : s + "->" + root.val;

        // 已经到达叶子结点
        if (root.left == null && root.right == null) {
            resList.add(path);
            return;
        }

        if (root.left != null) dfs(root.left, path, resList);
        if (root.right != null) dfs(root.right, path, resList);
    }
}
