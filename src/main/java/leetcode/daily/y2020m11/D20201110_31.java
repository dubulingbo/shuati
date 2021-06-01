package leetcode.daily.y2020m11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author DubLBo
 * @since 2020-11-10 09:34
 * i believe i can i do
 */
public class D20201110_31 {
    // 31. 下一个排列
    public void nextPermutation01(int[] nums) {
        // 1.从左往右找到第一个出现升序的连续的两个数num[i-1],num[i]，此时因为满足 nums[i-1]<nums[i], num[i]>=nums[i+1:]
        //      若不存在，直接返回升序数组，否则，接着下面的操作：
        // 2. 在[i+1:]中的寻找 > nums[i-1]的最大的下标k，
        //      若存在这样的 k ，交换nums[i-1]与nums[k],再将nums[i...]的数升序排列，就是答案；
        //      若不存在这样的 k ，交换nums[i-1]与nums[i],再将nums[i...]的数升序排列，就是答案；
        if (nums.length < 2) return;
        int i = nums.length - 1;
        // 寻找第一对连续的升序数对
        while (i > 0 && nums[i] <= nums[i - 1]) i--;

        // 没找到
        if (i == 0) {
            // 将数组升序排列
            Arrays.sort(nums);
        } else {
            int k = nums.length - 1;
            while (k > i && nums[i - 1] >= nums[k]) k--;
            int t = nums[i - 1];
            nums[i - 1] = nums[k];
            nums[k] = t;
            Arrays.sort(nums, i, nums.length);
        }
    }

    public void nextPermutation(int[] nums) {
        // 从左往右找到第一个比当前nums[i]大一点点的数，进行交换，然后再将nums[i+1 ...]的数升序排列，就是答案；
        // 大顶堆 + hash索引
        if (nums.length < 2) return;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // 将nums[i]与i建立索引
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int i = nums.length - 1;
        int pre;

        for (; i >= 0; i--) {
            indexMap.put(nums[i], i);
            if (maxHeap.isEmpty() || maxHeap.peek() <= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                // 存在比nums[i]大的数，找到这个比nums[i]大一点点的数
                pre = maxHeap.poll();
                while (!maxHeap.isEmpty() && maxHeap.peek() > nums[i]) {
                    pre = maxHeap.poll();
                }
                // 将找到的数与nums[i]进行交换
                int k = indexMap.get(pre);
                nums[k] = nums[i];
                nums[i] = pre;
                break;
            }
        }


        if (i == -1) {
            // 没找到
            // 将数组升序排列
            Arrays.sort(nums);
        } else {
            // 找到了，并且已经交换，再将最后的nums[i+1 ...]重新排列
            Arrays.sort(nums, i + 1, nums.length);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 33, 33, 5, 3, 2, 0};
        D20201110_31 test = new D20201110_31();
        test.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {1, 3, 2};
        test.nextPermutation01(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
