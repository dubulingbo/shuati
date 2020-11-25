package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author DubLBo
 * @since 2020-11-02 09:15
 * i believe i can i do
 */
public class T5539 {
    // 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
    // 请你返回排序后的数组。
    public int[] frequencySort(int[] nums) {
        // HashMap + 自定义排序规则
        HashMap<Integer,Integer> map = new HashMap<>();
        Integer[] arr = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            int occurTimes = map.getOrDefault(nums[i], 0);
            map.put(nums[i], occurTimes + 1);
            arr[i] = nums[i];
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // o1 在 o2 "前面" 升序
                // 按出现次数升序排列
                int k = map.get(o1).compareTo(map.get(o2));
                // 出现次数相同，按本身的大小进行降序排列
                if(k == 0) return o2.compareTo(o1);
                return k;
            }
        });

        return Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T5539().frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(new T5539().frequencySort(new int[]{2,3,1,3,2})));
        System.out.println(Arrays.toString(new T5539().frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1})));
        System.out.println(Arrays.toString(new T5539().frequencySort(new int[]{2,3,1,3,2})));

    }
}
