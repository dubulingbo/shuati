package leetcode.daily.y2020m12;

import java.util.HashMap;
import java.util.Map;

public class D20201204_659 {
    // 659. 分割数组为连续子序列
    public boolean isPossible(int[] nums) {
        if (nums.length < 3) return false;
        // key 的剩余次数（value）
        Map<Integer, Integer> countMap = new HashMap<>();
        // 存储以 key 结尾的 连续至少三个整数的子序列 的 value 的数量
        Map<Integer, Integer> endMap = new HashMap<>();

        for (int num : nums) {
            int times = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, times);
        }

        for (int num : nums) {
            int restTimes = countMap.getOrDefault(num, 0);
            if (restTimes > 0) {
                // 下面考虑怎么将 num 加入 endMap
                // 若 endMap 存在 以 num - 1 的子序列，需要将 num 加入到 num - 1 子序列序列中
                // 若不存在，则应该新建一个以 num 起始的连续至少三个整数的子序列，则必须要检查 countMap 中是否还有 num + 1 和 num + 2
                int endNum = endMap.getOrDefault(num - 1, 0);
                if (endNum > 0) {
                    // endMap 中存在 num - 1
                    // 将 endMap 中的 num - 1 结尾的子序列减一，将 num 结尾的子序列数量加一
                    // 将 countMap 中的 num 剩余次数减一
                    endMap.put(num - 1, endNum - 1);
                    endMap.put(num, endMap.getOrDefault(num, 0) + 1);
                    countMap.put(num, restTimes - 1);
                } else {
                    // endMap 中不存在 num - 1
                    int count1 = countMap.getOrDefault(num + 1, 0);
                    int count2 = countMap.getOrDefault(num + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        // countMap 中还有 num + 1 和 num + 2
                        countMap.put(num, restTimes - 1);
                        countMap.put(num + 1, count1 - 1);
                        countMap.put(num + 2, count2 - 1);
                        endMap.put(num + 2, endMap.getOrDefault(num + 2, 0) + 1);

                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(new D20201204_659().isPossible(new int[] {1,2,3,3,4,5}));
    }
}
