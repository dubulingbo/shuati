package leetcode.daily.y2020m11;

import java.util.Arrays;
import java.util.HashMap;

public class D20201127_454 {
    // 454. 四数相加 II
    public int fourSumCount01(int[] A, int[] B, int[] C, int[] D) {
        // 暴力 + 优化
        int ans = 0;
        Arrays.sort(D);
        Arrays.sort(C);
        Arrays.sort(B);
        for (int a = 0; a < A.length; a++) {
            int prevCntB = 0;
            for (int b = 0; b < B.length; b++) {
                if (A[a] + B[b] + C[0] + D[0] > 0) break;
                if (b != 0 && B[b] == B[b - 1]) {
                    ans += prevCntB;
                    continue;
                }
                int d = D.length - 1;
                // 上一次计数
                int prevCntC = 0;
                prevCntB = 0;
                for (int c = 0; c < C.length; c++) {
                    if (A[a] + B[b] + C[c] + D[0] > 0) break;
                    // 如果当前的数与前一个数相等，那么直接加上前一个回合的计数就 OK
                    if (c != 0 && C[c] == C[c - 1]) {
                        // ans += prevCntC;
                        prevCntB += prevCntC;
                        continue;
                    }
                    // 上一回合的数清零，准备记录本回合的满足条件的元组数;
                    prevCntC = 0;
                    int t = A[a] + B[b] + C[c];
                    if (t + D[0] > 0 || t + D[d] < 0) continue;
                    while (d >= 0 && t + D[d] >= 0) {
                        if (t + D[d] == 0) prevCntC++;
                        d--;
                    }
                    prevCntB += prevCntC;
                    // ans += prevCnt;
                }
                ans += prevCntB;
            }

        }
        return ans;
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 分组 + HashMap
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int times = countMap.getOrDefault(a + b, 0);
                countMap.put(a + b, times + 1);
            }
        }
        int cnt = 0;
        for (int c : C) {
            for (int d : D) {
                int key = -c - d;
                if (countMap.containsKey(key)) {
                    cnt += countMap.get(key);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-1, 0, -1, 1, 1, 1};
        int[] B = new int[]{1, -1, -1, 1, -1, 1};
        int[] C = new int[]{1, 0, 0, -1, -1, 0};
        int[] D = new int[]{1, -1, 0, 0, 0, -1};
        System.out.println(new D20201127_454().fourSumCount(A, B, C, D));
    }


}
