package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-11-18 14:30
 * i believe i can i do
 */
public class T1582 {
    // 1582. 二进制矩阵中的特殊位置
    public int numSpecial(int[][] mat) {
        // 分别统计 每行，每列 的和
        int[] rowSum = new int[mat.length];
        int[] colSum = new int[mat[0].length];
        // 存储所有可能的 1
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if(rowSum[i] == 0 && colSum[j] == 0) {
                        list.add(new int[]{i, j});
                    }
                    rowSum[i] += mat[i][j];
                    colSum[j] += mat[i][j];
                }
            }
        }

        int ans = 0;
        for(int[] dir : list){
            if(rowSum[dir[0]] == 1 && colSum[dir[1]] == 1) {
                ans++;
            }
        }

        return ans;
    }
}
