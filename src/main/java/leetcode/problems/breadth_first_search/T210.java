package leetcode.problems.breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-11-05 21:59
 * i believe i can i do
 */
public class T210 {
    // 210. 课程表 II
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 广搜实现拓扑排序
        List<List<Integer>> edges = new ArrayList<>();
        int[] inNums = new int[numCourses];

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
        int[] ans = new int[numCourses];
        // 起始时，所有入度为 0 的节点入队
        for (int i = 0; i < inNums.length; i++) {
            // 入度为 0 的节点 i
            if (inNums[i] == 0) queue.offer(i);
        }

        // 记录答案列表中的节点数
        int k = 0;
        while(!queue.isEmpty()){
            for(int i = queue.size();i>0;i--){
                int u = queue.poll();
                ans[k++] = u;
                for(int v : edges.get(u)){
                    inNums[v]--;
                    if(inNums[v] == 0) queue.offer(v);
                }
            }
        }
        return ans;
    }
}
