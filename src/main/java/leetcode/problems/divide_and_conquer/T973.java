package leetcode.problems.divide_and_conquer;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-11-04 19:23
 * i believe i can i do
 */
public class T973 {
    public int[][] kClosest_customSort(int[][] points, int K) {
        Arrays.sort(points, (o1, o2) -> {
            int s1 = o1[0] * o1[0] + o1[1] * o1[1];
            int s2 = o2[0] * o2[0] + o2[1] * o2[1];
            return s1 - s2;
        });

        return Arrays.copyOfRange(points, 0, K);
    }

    public int[][] kClosest(int[][] points, int k) {
        // 快排分区算法：求 topN
        if (points.length == 0) return new int[][]{};
        if (k >= points.length) return points;
        int left = 0, right = points.length - 1, pos = -1;
        while (pos != k - 1) {
            pos = partition(points, left, right);
            if (pos < k - 1) left = pos + 1;
            if (pos > k - 1) right = pos - 1;
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    public int partition(int[][] p, int left, int right) {
        int[] key = p[left];
        int keyDis = dist(p[left][0], p[left][1]);
        while (left < right) {
            while (left < right && (p[right][0] * p[right][0] + p[right][1] * p[right][1]) >= keyDis) right--;
//            if (left < right) swap(p, left, right);
            if (left < right) p[left] = p[right];
            while (left < right && (p[left][0] * p[left][0] + p[left][1] * p[left][1]) <= keyDis) left++;
//            if (left < right) swap(p, left, right);
            if (left < right) p[right] = p[left];
        }
//        swap(p, left, right);
        p[left] = key;
        return left;
    }

    private void swap(int[][] p, int left, int right) {
        int[] tmp = p[left];
        p[left] = p[right];
        p[right] = tmp;
    }

    /**
     * 计算点(x,y)到(0,0)的距离的平方
     *
     * @param x 横坐标
     * @param y 纵坐标
     * @return 距离的平方
     */
    private int dist(int x, int y) {
        return x * x + y * y;
    }
}
