package leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author DubLBo
 * @since 2020-11-02 09:18
 * i believe i can i do
 */
public class D20201102_349 {
    // 349. 两个数组的交集
    // 给定两个数组，编写一个函数来计算它们的交集。
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
//        HashSet<Integer> set2 = new HashSet<>();

        for (int j : nums1) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            }
        }

        int[] res = new int[map.size()];
        int k = 0;
        for (int num : nums2) {
            int occurNum = map.getOrDefault(num, 0);
            if (occurNum == 1) {
                // num 是 nums1 和 nums2 共同的元素
                res[k++] = num;
                map.put(num, occurNum + 1);
            }
        }

        return Arrays.copyOfRange(res, 0, k);
    }
}
