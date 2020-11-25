package leetcode.icci;


/**
 * @author DubLBo
 * @since 2020-10-30 15:36
 * i believe i can i do
 */
public class T10_09 {
    // 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        // 初始位置定在 右上角
        int x = 0;
        int y = col - 1;

        while (x < row && y >= 0) {
            if(target == matrix[x][y]) return true;
            // target 比当前元素的值大，则目标可能在当前行的下方，直接排除当前行
            else if(target > matrix[x][y]) x++;
            // target 比当前元素的值小，则目标可能在当前列的左方，直接排除当前列
            else y--;
        }
        return false;
    }
}
