package leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-11-12 08:59
 * i believe i can i do
 */
public class D20201112_922 {
    // 922. 按奇偶排序数组 II
    // 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
    // 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
    // 你可以返回任何满足上述条件的数组作为答案。
    public int[] sortArrayByParityII(int[] A) {
        // 奇偶双指针
        int even = 0, odd = 1;

        while (even < A.length) {
            // 找第一个出现偶数下标中存放的是奇数的位置
            while (even < A.length && A[even] % 2 == 0) even += 2;
            // 偶数位置都已经找到，就没有必要再循环奇数位置了
            if (even == A.length) break;
            // 找第一个出现奇数下标中存放的是偶数的位置
            while (odd < A.length && A[odd] % 2 != 0) odd += 2;
            // 需要交换
            if (odd < A.length) {
                int t = A[even];
                A[even] = A[odd];
                A[odd] = t;
            }
        }
        return A;
    }


    public int[] sortArrayByParityII01(int[] A) {
        // 奇偶双指针
//        int even = 0, odd = 1;
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();


        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 != 0) even.add(i);
            if (A[i + 1] % 2 == 0) odd.add(i + 1);
        }

        // 交换
        for (int i = 0; i < even.size() && i < odd.size(); i++) {
            swap(A, even.get(i), odd.get(i));
        }

        return A;
    }

    public int[] sortArrayByParityII02(int[] A) {
        // 奇偶双指针：对偶数下标循环，再起冲突时，循环奇数下标，再交换，以此类推！
        int odd = 1;
        for (int even = 0; even < A.length; even += 2) {
            if (A[even] % 2 == 1) {
                while (A[odd] % 2 == 1) {
                    odd += 2;
                }

                // 交换 A[even] 与 A[odd]
                // swap(A, even, odd);
                int t = A[even];
                A[even] = A[odd];
                A[odd] = t;
            }

        }
        return A;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new D20201112_922().sortArrayByParityII01(new int[]{2, 3, 1, 1, 4, 0, 0, 4, 3, 3})));
    }
}
