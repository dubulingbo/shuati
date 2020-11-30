package leetcode.problems;

public class T289 {
    // 289. 生命游戏
    public void gameOfLife(int[][] board) {

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int row = board.length;
        int col = board[0].length;

        // 枚举每一个格子里的细胞
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    if (newX < row && newX >= 0 && newY < col && newY >= 0 && board[newX][newY] > 0) {
                        live++;
                    }
                }

                // 之前是活细胞，现在应该为死细胞，标记为 2
                if ((board[i][j] == 1) && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }

                // 之前为死细胞，现在变为活细胞了，标记为 -1
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = -1;
                }
            }
        }

        // 遍历 board 得到一次更新后的状态
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                } else if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
