package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-11 13:58
 * i believe i can i do
 */
public class T1572 {
    // 1572. 矩阵对角线元素的和
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int len = mat.length;
        if (len % 2 == 1) sum += mat[len / 2][len / 2];
        for (int i = 0; i < len / 2; i++) {
            sum += (mat[i][i] + mat[i][len - 1 - i] + mat[len - 1 - i][len - 1 - i] + mat[len - 1 - i][i]);
        }

        return sum;
    }
}
