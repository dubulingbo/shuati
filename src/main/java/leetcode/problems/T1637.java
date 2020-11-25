package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author DubLBo
 * @since 2020-11-02 12:43
 * i believe i can i do
 */
public class T1637 {
    // 1637. 两点之间不包含任何点的最宽垂直面积
    // 给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直面积 的宽度。
    // 垂直面积 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直面积 为宽度最大的一个垂直面积。
    // 请注意，垂直区域边上的点不在 区域内。
    //链接：https://leetcode-cn.com/problems/widest-vertical-area-between-two-points-containing-no-points
    public int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> hashSet = new HashSet<>();
        for (int[] point : points) {
            hashSet.add(point[0]);
        }
        if (hashSet.size() <= 1) return 0;

        int ans = 0;
        List<Integer> list = new ArrayList<>(hashSet);
        list.sort(Integer::compareTo);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) > ans) {
                ans = list.get(i) - list.get(i - 1);
            }
        }
        return ans;
    }
}
