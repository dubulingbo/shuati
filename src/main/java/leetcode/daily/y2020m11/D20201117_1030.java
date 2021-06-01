package leetcode.daily.y2020m11;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-11-17 09:28
 * i believe i can i do
 */
public class D20201117_1030 {
    // 1030. 距离顺序排列矩阵单元格
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        // 枚举所有距离之和，即行列的增量之和
        int[][] ans = new int[R * C][2];
        int dist = 0;
        int index = 0;
        // 表示增量方向，即正负两个方向
        int[] d = {1, -1};
        while (index < R * C) {
            // 枚举行距离
            for (int rowD = 0; rowD <= dist; rowD++) {
                // 总距离 - 行距离 就是 列距离
                int colD = dist - rowD;
                // 枚举行方向的两个增量方向
                for (int i = 0; i < 2; i++) {
                    int newX = r0 + d[i] * rowD;
                    // 枚举列方向的两个增量方向
                    for (int j = 0; j < 2; j++) {
                        int newY = c0 + d[j] * colD;
                        // 判断当前的新格子是否越界
                        if (newX >= 0 && newX < R && newY >= 0 && newY < C) {
                            ans[index][0] = newX;
                            ans[index][1] = newY;
                            index++;
                        }
                        //距离为零只能枚举一次，因为 增量 0 * -1 = 0 * 1
                        if(colD == 0) break;
                    }
                    //距离为零只能枚举一次，因为 增量 0 * -1 = 0 * 1
                    if(rowD == 0) break;
                }
            }
            // 距离加一，为下次枚举做准备
            dist++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new D20201117_1030().allCellsDistOrder(2, 2, 0, 1)));
    }
}
