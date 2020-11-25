package leetcode.daily;

import java.util.Arrays;
import java.util.Comparator;

public class D20201123_452 {
    // 452. 用最少数量的箭引爆气球
    public int findMinArrowShots(int[][] points) {
        // 排序 + 贪心
        // 对右端点进行升序排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // o1[1] - o2[1] 可能会超出 int 的范围，这个时候可以用比较运算法进行比较
                if (o1[1] > o2[1]) return 3;
                else if (o1[1] < o2[1]) return -3;
                else return 0;
            }
        });

        int ans = 1;
        int l = points[0][1];
        // 总是取最小的最右端断点进行比较
        for (int[] p : points) {
            if (l < p[0]) {
                ans++;
                l = p[1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D20201123_452().findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
    }
}
