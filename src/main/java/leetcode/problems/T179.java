package leetcode.problems;

import java.util.Arrays;

public class T179 {
    // 179. 最大数
    private int[] tmpArr;
    public String largestNumber(int[] nums) {
        // 自定义归并排序
//        tmpArr = new int[nums.length];
//        System.arraycopy(nums, 0, tmpArr, 0, nums.length);
        tmpArr = Arrays.copyOfRange(nums, 0 , nums.length);
        customMergeSort(nums, 0, nums.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int num : nums) sb.append(num);
        return sb.length() > 0 && sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    private void customMergeSort(int[] nums, int left, int right) {
        // 1. 单个元素或没有元素就不用排序
        if (left >= right) return;
        // 2. 分别排序两个子序列
        int mid = (left + right) / 2;
        customMergeSort(nums, left, mid);
        customMergeSort(nums, mid + 1, right);
        // 3. 合并两个有序的子序列
        customMerge(nums, left, mid, right);
    }

    // 合并两个有序的序列 nums[left, mid] 和 nums[mid+1, right]
    private void customMerge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid || j <= right) {
            if (i == mid + 1) {
                nums[k++] = tmpArr[j++];
            } else if (j == right + 1) {
                nums[k++] = tmpArr[i++];
            } else if (compare(tmpArr[i], tmpArr[j]) < 0) {
                nums[k++] = tmpArr[j++];
            } else {
                nums[k++] = tmpArr[i++];
            }
        }
        System.arraycopy(nums, left, tmpArr, left, right - left + 1);
//        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
    }

    // 自定义排序规则： ab  ba
    private int compare(int a, int b) {
        StringBuilder ab = new StringBuilder();
        StringBuilder ba = new StringBuilder();
        ab.append(a).append(b);
        ba.append(b).append(a);
        return ab.toString().compareTo(ba.toString());
    }

    public static void main(String[] args) {
        System.out.println(new T179().largestNumber(new int[] {3,30,34,5,9}));
        System.out.println(new T179().largestNumber(new int[] {10, 2}));
        System.out.println(new T179().largestNumber(new int[] {10}));
        System.out.println(new T179().largestNumber(new int[] {1}));
        System.out.println(new T179().largestNumber(new int[] {}));
    }
}
