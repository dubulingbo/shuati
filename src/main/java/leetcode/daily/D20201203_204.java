package leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D20201203_204 {
    // 204. 计数质数
    public int countPrimes(int n) {
        if (n < 2) return 0;
//        if (n == 2) return 1;
//        if (n == 3) return 2;
        int len = (int) Math.sqrt(n);
        boolean[] noPrimeTable = new boolean[n];
//        Arrays.fill(primeTable, true);
        int cnt = 1;
        for (int i = 2; i <= len; i++) {
            if (!noPrimeTable[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    if (!noPrimeTable[j]) {
                        cnt++;
                        noPrimeTable[j] = true;
                    }
                }
            }
        }

        return n - cnt - 1;
    }

    public static void main(String[] args) {
        System.out.println(new D20201203_204().countPrimes(4));
        System.out.println(new D20201203_204().countPrimes(10));
        System.out.println(new D20201203_204().countPrimes(12));
        System.out.println(new D20201203_204().countPrimes(1));
        System.out.println(new D20201203_204().countPrimes(2));
    }
}
