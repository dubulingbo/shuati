package leetcode.icci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-10-27 20:15
 * i believe i can i do
 */
public class T08_10 {
    // 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
    // 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的横坐标为 sr 纵坐标为 sc。需要填充的新颜色为 newColor 。
    // 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
    // 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
    public int[][] floodFill_bfs(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 0};
        int oldColor = image[sr][sc];
        int row = image.length;
        int col = image[0].length;
        boolean[][] visited = new boolean[row][col];

        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] pos = queue.poll();
                image[pos[0]][pos[1]] = newColor;
                for (int j = 0; j < 4; j++) {
                    int newX = pos[0] + dx[j];
                    int newY = pos[1] + dy[j];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX][newY] && image[newX][newY] == oldColor) {
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return image;
    }

    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] image, int row, int col, int oldColor, int newColor, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col) return;

        // 判断当前格子是否还没填色，
        if (image[x][y] == newColor || image[x][y] != oldColor) return;

        // 涂色
        image[x][y] = newColor;

        // 遍历四周
        for (int i = 0; i < 4; i++) dfs(image, row, col, oldColor, newColor, x + dir[i][0], y + dir[i][1]);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, image.length, image[0].length, image[sr][sc], newColor, sr, sc);
        return image;
    }
}
