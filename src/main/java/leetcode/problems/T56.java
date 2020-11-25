package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-11-08 14:08
 * i believe i can i do
 */
public class T56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];

        // 先将 intervals 按照第一个数排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        int preX = intervals[0][0];
        int preY = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (preY < intervals[i][0]) {
                list.add(new int[]{preX, preY});
                preX = intervals[i][0];
                preY = intervals[i][1];
            } else {
                preY = Math.max(preY, intervals[i][1]);
            }
        }
        list.add(new int[]{preX, preY});
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] inter = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(new T56().merge(inter));
    }
}
