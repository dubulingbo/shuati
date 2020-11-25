package leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-11-12 14:39
 * i believe i can i do
 */
public class T547 {
    public int findCircleNum01(int[][] M) {
        // 广度优先搜索
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[M.length];

        int ans = 0;
        // 枚举所有的点（个人）
        for (int i = 0; i < M.length; i++) {
            // 没有访问过得才进行搜索
            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    // 寻找搜索与 cur 有直接联系的下一个点
                    for (int j = 0; j < M.length; j++) {
                        if (!visited[j] && M[cur][j] == 1) {
                            queue.offer(j);
                            visited[j] = true;
                        }
                    }
                }
                // 说明已经找到一个朋友圈的所有人
                ans++;
            }
        }
        return ans;
    }

    /**
     * 寻找节点 k 的祖先节点
     */
    private int find(int[] parent, int k) {
        while (parent[k] != -1) {
            k = parent[k];
        }
        return k;
    }

    /**
     * 合并两个节点
     */
    private void union(int[] parent, int i, int j) {
        // 获取 i 的祖先节点
        int iParent = find(parent, i);

        // 获取 j 的祖先节点
        int jParent = find(parent, j);

        // 如果 i 和 j 的祖先节点不相同，需要合并，规定将【j 家族】合并到【i 家族】中，即
        if (iParent != jParent) {
            parent[jParent] = iParent;
        }
    }

    public int findCircleNum(int[][] M) {
        // 并查集
        // parent[i] 表示 i 的父亲节点，初始为 -1，表示 i 本身就是根节点（祖先节点）
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);

        // 枚举所有的点（个人）
        for (int i = 0; i < M.length; i++) {
            // 寻找搜索与 cur 有直接联系的下一个点
            for (int j = 0; j < M.length; j++) {
                // 不是本身  &&  i 与 j 有联系
                if (i != j && M[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        // parent[] 中有多少个 -1 就表示有多少连通分量（有多少朋友圈）
        int ans = 0;
        for (int j : parent) {
            if (j == -1) ans++;
        }
        return ans;
    }
}
