package leetcode.daily;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-11-06 12:25
 * i believe i can i do
 */
public class D20201106_1356 {
    // 1356. 根据数字二进制下 1 的数目排序
    // 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
    // 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。请你返回排序后的数组。
    //链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits
    public int[] sortByBits_01(int[] arr) {
        if(arr.length <= 1) return arr;
        int[][] assArr = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            assArr[i][0] = countOne(arr[i]);
            assArr[i][1] = arr[i];
        }

        Arrays.sort(assArr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) res[i] = assArr[i][1];
        return res;
    }

    /**
     * 计算一个32为整数的二进制中 1 的个数
     */
    private int countOne(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1) count++;
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {
        if(arr.length <= 1) return arr;
//        int[][] assArr = new int[arr.length][2];
        // 因为题目给出的数组中的元素大小为[0,10^4]
        int p = 100000;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.bitCount(arr[i]) * p + arr[i];
        }

        Arrays.sort(arr);

        // 还原 arr 中的原来的元素值
        for (int i = 0; i < arr.length; i++) arr[i] = arr[i] % p;
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new D20201106_1356().sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
        System.out.println(Integer.bitCount(-1));
        System.out.println(Integer.bitCount(-2));
//        System.out.println(Integer.bitCount(-1));
    }

}
