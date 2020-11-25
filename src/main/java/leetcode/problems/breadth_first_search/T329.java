package leetcode.problems.breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-11-06 13:44
 * i believe i can i do
 */
public class T329 {
    // 给定一个整数矩阵，找出最长递增路径的长度。
    // 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
    public int longestIncreasingPath01(int[][] matrix) {
        // 广度优先搜索寻找拓扑排序
        // 将每个单元格 (i,j) 看成一个节点，如果 (i,j) 与它相邻的节点的值不相等，就会存在有向边
        // 初始条件：寻找入度为 0 的点入队
        if (matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] indegs = new int[row][col];

        // 构建初始条件
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 记录点(i,j)与四个方向的点的值的大小
                for (int k = 0; k < 4; k++) {
                    int ri = i + dx[k];
                    int rj = j + dy[k];
                    if (ri >= 0 && ri < row && rj >= 0 && rj < col && matrix[i][j] > matrix[ri][rj]) {
                        indegs[i][j]++;
                    }
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (indegs[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] dir = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = dir[0] + dx[j];
                    int newY = dir[1] + dy[j];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col && matrix[newX][newY] > matrix[dir[0]][dir[1]]) {
                        indegs[newX][newY]--;
                        if (indegs[newX][newY] == 0) {
                            queue.add(new int[]{newX, newY});
                        }
                    }
                }
            }
            // 记录遍历的层数
            ans++;
        }
        return ans;
    }

    private int row;
    private int col;
    private int[][] memo;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public int longestIncreasingPath(int[][] matrix) {
        // 深度优先搜索 + 记忆化
        // 最长的递增序列就是每个点的最长递增序列的最大值
        if(matrix.length == 0) return 0;
        row = matrix.length;
        col = matrix[0].length;
        // 记录已经搜索过的点的最长递增序列的长度
        memo = new int[row][col];

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (memo[i][j] != 0) {
                    ans = Math.max(memo[i][j], ans);
                } else {
                    ans = Math.max(ans, dfs(matrix, i, j));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int x, int y) {
        if (memo[x][y] != 0) return memo[x][y];

        memo[x][y]++;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < row && newY >= 0 && newY < col && matrix[newX][newY] > matrix[x][y]) {
                // 可以去到达(newX,newY)
                memo[x][y] = Math.max(memo[x][y], dfs(matrix, newX, newY) + 1);
            }
        }
        return memo[x][y];
    }

    public static void main(String[] args) {
        int[][] nums = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(new T329().longestIncreasingPath(nums));

        int[][] nums1 = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        System.out.println(new T329().longestIncreasingPath(nums1));
    }
}
