package leetcode.problems;

import java.util.Arrays;

/**
 * @author DubLBo
 * @since 2020-11-09 17:36
 * i believe i can i do
 */
public class T204 {
    // 计算质数
    public int countPrimes(int n) {
        // 质数表法
        int ans = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) { // i 是质数，得要排除 i的倍数
                for (int j = i + i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T204().countPrimes(150000));
        System.out.println(new T204().countPrimes(0));
        System.out.println(new T204().countPrimes(1));
    }
}
