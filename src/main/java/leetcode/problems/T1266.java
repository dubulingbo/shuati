package leetcode.problems;

import java.util.Map;

/**
 * @author DubLBo
 * @since 2020-11-08 22:34
 * i believe i can i do
 */
public class T1266 {
    // 1266. 访问所有点的最小时间
    public int minTimeToVisitAllPoints(int[][] points) {
        // 循环
//        if (points.length <= 1) return 0;
        int time = 0;
        for (int i = 1; i < points.length; i++) {
            int x = Math.abs(points[i][0] - points[i-1][0]);
            int y = Math.abs(points[i][1] - points[i-1][1]);
            time += (Math.min(x,y) + Math.abs(x-y));
        }
        return time;
    }
}
