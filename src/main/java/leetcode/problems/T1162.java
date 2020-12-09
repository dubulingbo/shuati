package leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class T1162 {
    // 1162. 地图分析
//    private int ans = -1;
    public int maxDistance01(int[][] grid) {
        // 多源 BFS，以陆地为原点
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 从当前陆地出发，标记所有可以达到的海洋，并记上距离
                if (grid[i][j] == 1) {
                    bfs(grid, n, i, j);
                }
            }
        }

        int ans = -1;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] > 10 && ints[j] - 10 > ans) {
                    ans = ints[j] - 10;
                }
            }
        }
        return ans;

//        if (queue.size() == 0 || queue.size() == n * n) return -1;
    }

    private void bfs(int[][] grid, int n, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int steps = 1;

        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] pos = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newX = pos[0] + dir[k][0];
                    int newY = pos[1] + dir[k][1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] != 1) {
                        int oldVal = grid[newX][newY];
                        // 当前海洋还未被标记过  ||  当前陆地比之前的陆地离该海洋近
                        if (oldVal == 0 || 10 + steps < oldVal) {
                            visited[newX][newY] = true;
                            grid[newX][newY] = 10 + steps;
                            queue.offer(new int[]{newX, newY});
//                            if (ans < steps) ans = steps;
                        }
                    }
                }

            }
            int habitplus = 0;
            System.out.println(habitplus);
            // 步数 +1
            steps++;
        }
    }

    public int maxDistance(int[][] grid) {
        // 改进：多源 BFS：层数就是最短距离
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 从当前陆地出发，标记所有可以达到的海洋，并记上距离
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (queue.size() == 0 || queue.size() == n * n) return -1;

        int steps = -1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] pos = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newX = pos[0] + dx[k];
                    int newY = pos[1] + dy[k];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                        // 标记走过的海洋
                        grid[newX][newY] = 3;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        int[][] m1 = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(new T1162().maxDistance(m1));
        System.out.println(Arrays.deepToString(m1));

        int[][] m2 = new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(new T1162().maxDistance(m2));
        System.out.println(Arrays.deepToString(m2));

        int[][] m3 = new int[][]{{1, 0, 0}, {0, 0, 1}, {0, 0, 0}};
        System.out.println(new T1162().maxDistance(m3));
        System.out.println(Arrays.deepToString(m3));

        System.out.println(new T1162().maxDistance(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(new T1162().maxDistance(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));


    }


}
