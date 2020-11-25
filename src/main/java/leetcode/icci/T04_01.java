package leetcode.icci;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-10-23 13:02
 * i believe i can i do
 */
public class T04_01 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 建立邻接表
        HashSet<Integer>[] adj = new HashSet[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] ints : graph) {
            adj[ints[0]].add(ints[1]);
        }

        // BFS
        return bfs(adj, n, start, target);
    }

    private boolean bfs(HashSet<Integer>[] adj, int n, int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(start);
        Arrays.fill(visited, false);
        visited[start] = true;

        while(!queue.isEmpty()){

            for(int i=queue.size();i>0;i++){
                int cur = queue.poll();
                for(int next : adj[cur]){
                    if(next == target) return true;

                    if(!visited[next]){ // 被访问过
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }

        }

        return false;
    }
}
