package leetcode.daily.y2020m10;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author DubLBo
 * @since 2020-10-26 09:27
 * i believe i can i do
 */
public class D20201026_1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 排序 + 数组【去重计算】
        int[] ans = new int[nums.length];
        int[][] indexes = new int[nums.length][2];

        // 将数组原来的顺序存下来
        for (int i = 0; i < nums.length; i++) {
            indexes[i][0] = i;
            indexes[i][1] = nums[i];
        }

        Arrays.sort(indexes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 记录num[indexes[i][0]]元素之前有多少个比它小的元素个数【因为已对 indexes[i] 进行排序】
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            // 两个相等元素计数应该一样
            if (pre == -1 || indexes[i - 1][1] != indexes[i][1]) {
                pre = i;
            }
            // 记录比 indexes[idx][1]小的元素个数
            ans[indexes[i][0]] = pre;
        }
        return ans;
    }


    public int[] smallerNumbersThanCurrent_count(int[] nums) {
        // 计数排序【由于题目给出的条件中 nums 中的元素值在 [0,100]，所以可以使用类似桶排序】
        int[] ans = new int[nums.length];
        int[] count = new int[101];

        // 将 nums 数组中的元素按大小进行计数，计数完其实就有序了
        for (int num : nums) {
            count[num]++;
        }


        // 存储count[i]变化前的值，为下一次统计 count[i+1] 做缓存
        int pre = 0;
        // count[i] 记录 nums 数组中 <i 的元素个数，不可能存在比 0 小的数，所以 count[0] = 0
        for (int i = 1; i < count.length; i++) {
            int tmp = count[i];
            count[i] = count[i - 1] + pre;
            pre = tmp;
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = count[nums[i]];
        }
        return ans;
    }
}
