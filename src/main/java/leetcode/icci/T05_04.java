package leetcode.icci;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-10-26 20:37
 * i believe i can i do
 */
public class T05_04 {
    // 下一个数。给定一个正整数，找出与其二进制表达式中 1 的个数相同，且最接近的那两个数（一个略大，一个略小）

    private int countOne(int num) {
        int cnt = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                cnt++;
            }
            num >>= 1;
        }
        return cnt;
    }

    public int[] test(int num) {
        int x = num;
        int big = -1;
        int small = -1;
        // 记录 1 的个数
        int count = 0;
        // 记录二进制表达式中从低到高的第一个 1 的位置
        int first = -1;
        // 记录 第一个 1  之后的第一个 0；
        int second = -1;
        // 记录二进制表达式中从低到高的最后一个 1 的位置，即最高位
        int last = -1;
        while (x > 0) {
            last++;
            if ((x & 1) == 1) {
                count++;
                // 第一个为 1 的二进制位
                if (first == -1) first = last;
            }
            if (first != -1 && (x & 1) == 0) {
                second = last;
            }
            x >>= 1;
        }

        // 最低位的1不在第一位上，有较小值
        if (first != 1) {

        }
        // 最高位为第 31 位，且最高位与最低位之间都是 1，则没有较大值

        if (second != -1) {
            // 在最低位的 1 和最高位之间有0；
            big = num & (~(1 << first)) | (1 << second);
        } else if (last != 30) {
            big = num >> first + (1 << (last + 1)) - (1 << (last));
        }

        return new int[]{big, last, count};
    }

    public int[] findClosedNumbers(int num) {
        // 暴力法
        int target = countOne(num);

        int big = -1, small = -1;

        for (int i = num + 1; i < Integer.MAX_VALUE; i++) {
            if (countOne(i) == target) {
                big = i;
                break;
            }
        }

        for (int i = num - 1; i > 0; i--) {
            if (countOne(i) == target) {
                small = i;
                break;
            }
        }

        return new int[]{big, small};
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
//        System.out.println(Arrays.toString(new T05_04().test(Integer.MAX_VALUE)));
        System.out.println(Arrays.toString(new T05_04().findClosedNumbers(255)));
        System.out.println(Arrays.toString(new T05_04().findClosedNumbers(2)));
        System.out.println(Arrays.toString(new T05_04().findClosedNumbers(1)));
    }
}
