package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-05 15:56
 * i believe i can i do
 */
public class T999 {
    // 999. 可以被一步捕获的棋子数
    public int numRookCaptures(char[][] board) {
        // 搜索白车的位置
        int row = board.length;
        int col = board[0].length;
        int rx = row;
        int ry = col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    break;
                }
            }
        }

        int ans = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // 每个方向的步数；
        int d;
        // 模拟 车 行走
        for (int i = 0; i < 4; i++) {
            d = 1;
            while (true) {
                int x = rx + d * dx[i];
                int y = ry + d * dy[i];
                // 已越界 || 碰到白象
                if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] == 'B') {
                    break;
                }
                if (board[x][y] == 'p') {
                    ans++;
                    break;
                }
                d++;
            }
        }
        return ans;
    }
}
