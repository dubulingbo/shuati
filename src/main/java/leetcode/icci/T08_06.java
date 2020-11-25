package leetcode.icci;

import java.util.List;

/**
 * @author DubLBo
 * @since 2020-11-03 15:26
 * i believe i can i do
 */
public class T08_06 {
    // 面试题 08.06. 汉诺塔问题
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if (A.size() == 0) return;
        move(A.size(), A, B, C);
    }

    /**
     * 移盘子递归函数：将 A 上的 n 个盘子借助 B 柱子移动到 C 柱子
     *
     * @param n A柱子上的盘子总数
     * @param A 起始柱子
     * @param B 辅助柱子
     * @param C 目标柱子
     */
    private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            // 直接将 A 柱子上的盘子移到 C 柱子上
            C.add(A.remove(A.size() - 1));
            return;
        }
        // 将 A 柱子的上面 n-1 个盘子移动 B 柱子
        move(n-1, A, C, B);
        // 将 A 柱子上的第 n 个盘子直接移到 C 柱子上
        C.add(A.remove(A.size() - 1));
        // 将 B 柱子上的 n-1 个盘子移动到 C 柱子上
        move(n-1, B, A, C);
    }


}
