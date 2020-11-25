package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-17 20:51
 * i believe i can i do
 */
public class T1566 {
    // 1566. 重复至少 K 次且长度为 M 的模式
    public boolean containsPattern(int[] arr, int m, int k) {
        if (m * k > arr.length) return false;
        // 枚举 arr[i...i+m)
        for (int i = 0; i < arr.length; i++) {
            // 枚举每一次的重复
            int cnt = 1;
            for (; cnt <= k; cnt++) {
                int left = i + cnt * m;
                int right = i + (cnt + 1) * m;
                if (right < arr.length) {
                    while (left < right && arr[left] == arr[left - m]) left++;
                    // 本次匹配未成功
                    if (left < right) break;
                } else {
                    // 不可能存在满足 k 个连续的子序列了
                    break;
                }
            }
            // 说明找到了
            if (cnt == k) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T1566().containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 3));
    }
}
