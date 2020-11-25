package leetcode.problems;

public class T264 {
    // 264. 丑数 II
    // 编写一个程序，找出第 n 个丑数。
    // 丑数就是质因数只包含 2, 3, 5 的正整数。
    public int nthUglyNumber(int n) {
        // 递推：动态规划
        // p2, p3, p5 分为指向下个回合乘以2,3,5之后的最小数
        int[] uglyNum = new int[n];
        // 指向当前数的下标
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        uglyNum[0] = 1;

        for (int i = 1; i < n; i++) {
            uglyNum[i] = Math.min(uglyNum[p2] * 2, Math.min(uglyNum[p3] * 3, uglyNum[p5] * 5));

            // 调整 p2，p3，p5指向，如果当前 uglyNum[i] == pi *i，应该要 pi 指向下一位（i 为2、3、5）
            if(uglyNum[p2] * 2 == uglyNum[i]) p2++;
            if(uglyNum[p3] * 3 == uglyNum[i]) p3++;
            if(uglyNum[p5] * 5 == uglyNum[i]) p5++;
        }

        return uglyNum[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new T264().nthUglyNumber(10));
    }
}
