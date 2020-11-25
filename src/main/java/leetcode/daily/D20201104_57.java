package leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-11-04 08:47
 * i believe i can i do
 */
public class D20201104_57 {
    // 57. 插入区间
    // 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
    // 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 模拟
        if (newInterval.length == 0) return intervals;
        if (intervals.length == 0) return new int[][]{{newInterval[0], newInterval[1]}};
        int s = newInterval[0];
        int e = newInterval[1];
        // 标记[s,e]是否已经加入结果列表中，防止重复加入
        boolean isAdd = false;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < s) {
                // 当前区间在[s,e]的左侧，不相交，直接将当前区间加入结果列表
                list.add(intervals[i]);
            } else if (intervals[i][0] > e) {
                // 当前区间在[s,e]的右侧，不相交，[s,e]应该加入结果列表，且之后不再加入；当前区间也应该加入结果列表
                if (!isAdd) {
                    list.add((new int[]{s, e}));
                    isAdd = true;
                }
                list.add(intervals[i]);
            } else {
                // 当前区间和[s,e]有交集，更新[s,e]为这两个区间（[intervals[i][0],intervals[i][1]] 和 [s,e]）的并集
                s = Math.min(s, intervals[i][0]);
                e = Math.max(e, intervals[i][1]);
            }
        }
        // 最后还要判断一下[s,e]是不是还没加入
        if (!isAdd) list.add(new int[]{s, e});

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new D20201104_57().insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }
}
