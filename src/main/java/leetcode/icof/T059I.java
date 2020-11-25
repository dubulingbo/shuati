package leetcode.icof;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author DubLBo
 * @since 2020-10-17 09:05
 * i believe i can i do
 */
public class T059I {
    // 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 直接法，也叫暴力法
//        int i = 0, j = k, minNum = nums[i];
        if (nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        // 记录滑动窗口的最大值
        int maxNum;
        for (int i = 0; i < res.length; i++) {

            if (i != 0 && res[i-1] <= nums[i + k -1]) {
                // 法一：上一个滑动窗口的最大值比新加入的元素小，就说明当前窗口的最大值就是 nums[i+k-1]
                // 法二：如果上一个轮回的最大值不是要排除的元素的值，就说明当前轮回的最大值就是：当前元素和上一个轮回的最大值的较大者
                maxNum = nums[i + k - 1];
            } else {
                maxNum = nums[i];
                for (int j = i + 1; j < i + k; j++) {
                    maxNum = Math.max(maxNum, nums[j]);
                }
            }
            res[i] = maxNum;

        }
        return res;
    }

    public int[] maxSlidingWindow_deque(int[] nums, int k){
        // 双端队列 + 单调队列
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast(); // 保持 deque 递减
            deque.addLast(nums[j]);
            if(i >= 0)
                res[i] = deque.peekFirst();  // 记录窗口最大值
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new T059I().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(new T059I().maxSlidingWindow_deque(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
