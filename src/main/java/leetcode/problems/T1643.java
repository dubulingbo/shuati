package leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-11-02 13:09
 * i believe i can i do
 */
public class T1643 {
    // 1643. 第 K 条最小指令
    // Bob 站在单元格 (0, 0)，想要前往目的地 destination：(row, column)。他只能 向右 或 向下 走。
    // 你可以为 Bob 提供导航指令来帮助他到达目的地 destination 。指令用字符串表示，其中每个字符：
    //	    'H' ，意味着水平向右移动
    //	    'V' ，意味着竖直向下移动
    // 能够为 Bob 导航到目的地 destination 的指令可以有多种，例如，如果目的地 destination 是 (2, 3)，"HHHVV" 和 "HVHVH" 都是有效 指令 。
    // 然而，Bob 很挑剔。因为他的幸运数字是 k，他想要遵循 按字典序排列后的第 k 条最小指令 的导航前往目的地 destination 。k 的编号 从 1 开始 。
    //
    //给你一个整数数组 destination 和一个整数 k ，请你返回可以为 Bob 提供前往目的地 destination 导航的按字典序排列后的第 k 条最小指令 。
    private String targetPath;
    private int curNo;
    private List<String> tmpPath;

    public String kthSmallestPath(int[] destination, int k) {
        // dfs
        tmpPath = new LinkedList<>();
        targetPath = "";
        curNo = 0;
        dfs(0, 0, destination[0], destination[1], k);
        return targetPath;
//        return String.join("",path);
    }

    /**
     * @param i  当前所在方格的行号
     * @param j  当前所在方格的列号
     * @param x  终点的行号
     * @param y  终点的列号
//     * @param no 当前属于第几条可行路径（从零开始）
     * @param k  需要取的第 k 条路径
     */
    private void dfs(int i, int j, int x, int y, int k) {
        if (i == x && j == y) {
            // 已到达终点，找到了一条可行指令集
            if (++curNo == k) targetPath = String.join("", tmpPath);
            return;
        }
        // 能向右尽量向右
        if (j + 1 <= y && curNo < k) {
            tmpPath.add("H");
            dfs(i, j + 1, x, y, k);
            tmpPath.remove(tmpPath.size() - 1);
        }

        if (i + 1 <= x && curNo < k) {
            tmpPath.add("V");
            dfs(i + 1, j, x, y, k);
            tmpPath.remove(tmpPath.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new T1643().kthSmallestPath(new int[]{2, 3}, 1));
    }
}
