package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T51 {
    // 51. N 皇后
    // 52. N皇后 II
    public List<List<String>> solveNQueens(int n) {
        // 回溯法：第 i 个皇后放置在第 i 行
        List<List<String>> res = new ArrayList<>();

        // colIdx[i] 表示第 i 个皇后 放在第 i 行 的列下标
        int[] colIdx = new int[n];
        Arrays.fill(colIdx, -1);

        // 初始棋盘
        char[][] g = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(g[i], '.');

        place(n, 0, g, colIdx, res);

        return res;
    }

    // 将第 queenNo 个 皇后放在 第 queenNo 行上
    private void place(int n, int queenNo, char[][] g, int[] colIdx, List<List<String>> res) {
        if (queenNo == n) {
            // n 个皇后已经放置完
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add(new String(g[i]));
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (verify(queenNo, i, colIdx)) {
                // 该列可以放
                g[queenNo][i] = 'Q';
                colIdx[queenNo] = i;
                place(n, queenNo + 1, g, colIdx, res);
                // 回溯需要清空当前状态
                g[queenNo][i] = '.';
                colIdx[queenNo] = -1;
            }
        }
    }

    // 验证 第 x 个 皇后放在第 y 列是否合理
    private boolean verify(int x, int y, int[] colIdx) {
        for (int i = 0; i < x; i++) {
            // 当前列已经被占用了 || 与前面已经放好的皇后在同一斜线上
            if (y == colIdx[i] || Math.abs(x - i) == Math.abs(y - colIdx[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T51().solveNQueens(10));
    }
}
