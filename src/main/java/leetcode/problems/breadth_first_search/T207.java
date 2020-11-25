package leetcode.problems.breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-11-05 20:00
 * i believe i can i do
 */
public class T207 {
    // 207. 课程表
    // 本题是一道经典的拓扑排序！
    // 给定一个包含 n 个节点的有向图 G，给出它的节点编号的一种排序，如果满足：
    //      对于图 G 中的任意一条有向边 <u,v>，u 在排列中都出现在 v 的前面。
    // 那么称该排列是图 G 的拓扑排序！
    // 1. 如果图 G 中存在环（即图 G 不是有向无环图），那么图 G 不存在拓扑排序。
    // 2. 如果图 G 是有向无环图，那么它的拓扑排序可能不止一种。
    //    举个极端的例子，如果图 G 中没有任何边，那么任意一种编号的排列度可以作为图 G 的拓扑排序
    // 解题思路：本题其实就是寻找出图中是否存在环
    // 方法一：深度优先搜索
    // 用一个栈来存储已经搜索过的节点：
    //      对于一个节点 u，如果它的所有相邻节点都已经搜索完成，那么在回溯到 u 的时候，u 本身也会变成一个搜索完成的节点。
    //      这里的【相邻节点】指的是从 u 出发通过一条有向边可以到达的所有节点
    // 假设我们当前搜索到了节点 u，如果它的所有相邻的节点都已经搜索完成，那么这些节点都已经在栈中了，此时将 u 入栈。
    // 可以发现：如果我们从栈顶到栈底的顺序看，u 出现在所有相邻节点的前面。因此对于 u 这个节点而言，它是满足拓扑排序的要求的。
    // 这样一来，对图进行一遍深度优先搜索。当每个节点进行回溯的时候，我们把该节点放入栈中，最终从栈顶到栈底的序列就是一种拓扑排序。
    // 算法：
    // 对于图中的任意节点，他在搜索中有三种状态，即：
    //  1. 未搜索：表示还没有搜索到该节点
    //  2. 搜索中：表示搜索过这个节点，但还没回溯到该节点，即该节点还没入栈，还有相邻节点没有搜索完
    //  3. 已完成：搜索过这个节点且回溯过这个节点，即该节点已经入栈，并且所有该节点的相邻节点都出现在栈的更底部位置，满足拓扑排序的要求
    // 深度优先搜索得到拓扑排序的流程：
    //      在每一轮搜索开始时，任取一个【未搜索】的节点开始进行深度优先搜索：
    //          1. 将当前搜索的节点 u 标记为搜索中，遍历该节点的每一个相邻的节点 v：
    //              如果 v 为【未搜索】，那么就开始搜索 v，待搜索完成回溯到 u；
    //              如果 v 为【搜索中】，那么我们就找到了图中的一个环，因此是不存在拓扑排序的；
    //              如果 v 为【已完成】，那么说明 v 已经在栈中了，而 u 不在栈中，因此 u 无论何时入栈读不回影响到 (u,v) 之前的拓扑关系，即不要做任何操作
    //          2. 当 u 的所有相邻节点都为【已完成】时，将 u 放入栈中，并将其标记为【已完成】
    //      在整个深度优先搜索过程结束后，如果没有找到图中的环，那么栈中存储的这所有的 n 个节点，从栈顶到栈底的顺序就是一种拓扑排序。
    // 由于本题是只需要判断是否存在拓扑排序，而栈的作用是存放最终的拓扑排序的结果，因此可以只记录每个节点的状态，而省去对应的栈。
    // 时间复杂度为 O(n + m) n为节点数，m为有向边数
    // 空间复杂度：O(n + m)
    // 使用邻接矩阵来存储图的有向边信息
    private List<List<Integer>> edges;
    // 标记节点的状态，默认 0 表示【未搜索】
    private int[] visited;
    // 标记是否存在拓扑排序，即不存在环，默认存在
    private boolean valid;

    public boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        visited = new int[numCourses];
        valid = true;

        // 建立邻接矩阵：节点信息 + 边信息
        for (int i = 0; i < numCourses; i++) {
            edges.add(new LinkedList<>());
        }
        for (int[] arr : prerequisites) {
            edges.get(arr[1]).add(arr[0]);
        }

        // 找寻所有【未搜索】的节点进行 dfs
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] != 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int u) {
        // 标记当前节点为【搜索中】
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                // 未搜索，进行搜索，回溯再标记
                dfs(v);
                // 在搜索 v 的过程中存在环，直接返回，无需再进行之后的深度搜索了
                if (!valid) return;
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        // 标记当前节点为【已完成】
        visited[u] = 2;
    }


    // 方法二：广度优先搜索
    // 法一相当于一种逆向思维，最先被放入栈中的节点是在拓扑排序中最后面的节点。那广搜就是顺序地产生拓扑排序的过程。
    // 思路：
    // 考虑拓扑排序最前面的点，该节点应该是0入度的点，也就是没有任何的先修课程；
    // 当将这样的一个节点加入答案中后，我们就可以移除它的所有出边，代表着它的相邻节点少了一门先修课程，
    // 如果某个相邻节点变成了【没有任何入度的节点】，那么就代表该课程可以开始学习了。
    // 按照这样的流程，不断地将没有入度的点加入答案，直到答案列表中包含所有的节点（得到一种拓扑排序）或者不存在【0入度的节点】（图中包含环）
    // 算法：
    //      初始时，所有入度为零的节点放入队列，在搜索的每一步中，取出队首的节点 u：
    //          1. 将 u 放入答案列表中
    //          2. 移除 u 的所有出边，也就是将 u 的所有相邻节点的入度减 1。如果某个相邻节点 v 的入度为 0 了，就将 v 放入队列中。
    //      在广搜结束后，如果答案列表中包含了 n 个节点，那就找到了一种拓扑排序，否则说明图中存在环，也就是不存在拓扑排序
    // 由于本题是只需要判断是否存在拓扑排序，所以可以省去答案列表，只需要用一个变量记录被放入答案列表的节点个数，最后判断该变量是否等于全部节点数即可。

    // 存放每个节点的入度，默认为 0
    private int[] inNums;

    public boolean canFinish_bfs(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        inNums = new int[numCourses];
        valid = true;

        // 建立邻接矩阵：节点信息 + 边信息
        for (int i = 0; i < numCourses; i++) {
            edges.add(new LinkedList<>());
        }
        for (int[] arr : prerequisites) {
            // 有向边：<arr[1],arr[0]>
            edges.get(arr[1]).add(arr[0]);
            inNums[arr[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // 起始时，所有入度为 0 的节点入队
        for (int i = 0; i < inNums.length; i++) {
            // 入度为 0 的节点 i
            if (inNums[i] == 0) queue.offer(i);
        }
        // 记录答案列表中的节点数
        int nodeNum = 0;
        while(!queue.isEmpty()){
            nodeNum += queue.size();
            for(int i = queue.size();i>0;i--){
                int u = queue.poll();
                for(int v : edges.get(u)){
                    inNums[v]--;
                    if(inNums[v] == 0) queue.offer(v);
                }
            }
        }

        return nodeNum == numCourses;
    }

}
