package leetcode.problems;

import java.util.Arrays;

public class T48 {
    // 48. 旋转图像
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        // 对圈数循环
        for (int cycle = 0; cycle < n / 2; ++cycle) {
            for (int i = left; i < right ; ++i) {
                int t1 = matrix[top][i];
                int t2 = matrix[i][right];
                int t3 = matrix[bottom][n - 1 - i];
                int t4 = matrix[n - 1 - i][left];

                matrix[top][i] = t4;
                matrix[i][right] = t1;
                matrix[bottom][n - 1 - i] = t2;
                matrix[n - 1 - i][left] = t3;
            }
            top++;
            left++;
            bottom--;
            right--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
        new T48().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
