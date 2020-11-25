package leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author DubLBo
 * @since 2020-11-01 18:45
 * i believe i can i do
 */
public class T5556 {
    // 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
    // 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
    // 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
    //      如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
    //      如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
    //      如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
    //
    // 链接：https://leetcode-cn.com/problems/furthest-building-you-can-reach

    private int maxIndex = 0;
    // 记录能直接到达的连续楼层的下标的下一个位置
    Map<Integer, Integer> map;

    public int furthestBuilding_dfs(int[] heights, int bricks, int ladders) {
        // dfs
        if (heights.length <= 1) return 0;

        int[] brick = new int[heights.length];


        map = new HashMap<>();
        int start = 0;
        for (int i = 1; i < brick.length; i++) {
            if (heights[i] > heights[i - 1]) {
                brick[i] = heights[i] - heights[i - 1];
            }
            if (brick[i] > 0) {
                // 需要砖块才能到达 或 到达最后位置了
                map.put(start, i);
                start = i;
            }
        }

        if (start < brick.length - 1) {
            // 最后一层应该是不需要砖块就能到达的
            map.put(start, brick.length);
        }

        dfs(brick, map.get(0), bricks, ladders);

        return maxIndex;
    }

    /**
     * @param brick   brick[i] 表示从上一位置到达下标 i 所需的砖块
     * @param toIndex 即将达到的下标
     * @param bricks  剩余的砖块数
     * @param ladders 剩余的楼梯数
     */
    private void dfs(int[] brick, int toIndex, int bricks, int ladders) {
        if (maxIndex < toIndex - 1) {
            maxIndex = toIndex - 1;
        }

        // 能到达最后一层
        if (toIndex == brick.length) {
            maxIndex = brick.length - 1;
            return;
        }

        // 使用砖块上这一层
        if (brick[toIndex] <= bricks) {
            dfs(brick, map.getOrDefault(toIndex, brick.length), bricks - brick[toIndex], ladders);
        }

        // 使用楼梯上该层
        if (ladders > 0) {
            dfs(brick, map.getOrDefault(toIndex, brick.length), bricks, ladders - 1);
        }
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // 小顶堆
        // 思路：先使用梯子，梯子使用完后，找出使用梯子的楼层的最小高度差的楼层使用砖块，直到砖块使用完
        // 默认就是小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 1; i < heights.length; i++) {
            int h = heights[i] - heights[i - 1];
            if (h > 0) {
                // 要到达该位置需要使用梯子或砖块
                minHeap.add(h);

                if (minHeap.size() > ladders) {
                    // 梯子使用完了
                    // 弹出最小高度差的楼层
                    int dh = minHeap.poll();

                    if (dh > bricks) {
                        // 不能到达该位置，那就是前一个位置
                        return i - 1;
                    } else {
                        bricks -= dh;
                    }
                }
            }
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {

//        ArrayList<Integer> ins = new ArrayList<>();
//        ins.add(9);
//        ins.add(8);
//        ins.add(3);
//        ins.add(6);
//        ins.add(-2);
//
//        ins.sort(Comparator.reverseOrder());
//
//        System.out.println(ins);

        System.out.println(new T5556().furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
        System.out.println(new T5556().furthestBuilding(new int[]{14, 3, 19, 3}, 17, 0));
    }
}
