package leetcode.problems;

public class T962 {
    // 962. 最大宽度坡
    public int maxWidthRamp(int[] A) {
        // 暴力 + 数组优化
        int n = A.length;
        // maxNumIdx[i] 表示A[i, n) 中最大的数的最远（下标最大）下标
        int[] maxNumIdx = new int[n];
        int ans = 0;

        maxNumIdx[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; --i) {
            int maxNum = A[maxNumIdx[i+1]];
            // i之后没有不小于A[i]值了
            if (A[i] > maxNum)  maxNumIdx[i] = i;
            else {
                // A[i] <= maxNum
                if (maxNum == A[i]) {
                    if (ans < maxNumIdx[i+1] - i) ans = maxNumIdx[i+1] - i;
                } else {
                    int j = maxNumIdx[i+1];
                    do {
                        if (ans < j - i) ans = j - i;
                        int old = j;
                        j = maxNumIdx[j];
                        if (old == j) j = j + 1 < n ? maxNumIdx[j + 1] : j + 1;
                    } while (j < n && A[i] <= A[j]);
                }
                maxNumIdx[i] = maxNumIdx[i + 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T962().maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
        System.out.println(new T962().maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(new T962().maxWidthRamp(new int[]{2, 4, 1, 3}));
    }
}
