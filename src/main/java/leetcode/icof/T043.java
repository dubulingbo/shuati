package leetcode.icof;

/**
 * @author DubLBo
 * @since 2020-10-21 17:03
 * i believe i can i do
 */
public class T043 {
    // 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
    // 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
    public int countDigitOne(int n) {
        // 归纳总结：1~n 这 n 个数中出现 1 的个数 可以是 n 这个数的每个数位上出现 1 的次数的和
        // 对每个数位上的数字 k 进行循环：
        //      1. 若 k = 0，则当前位出现 1 的次数有高位决定，即 high * digit
        //      2. 若 k = 1，则当前位出现 1 的次数由高位和低位共同决定，即 high * digit + low + 1
        //      3. 若 k > 1，则当前位出现 1 的次数由高位决定，即 (high + 1) * digit

        int ans = 0;
        // 记录高位数
        int high = n / 10;
        // 当前数位的数值
        int cur = n % 10;
        // 低位数
        int low = 0;
        // 当前位处于的数位级（1,10,100,1000,1000...）
        int digit = 1;

        while (high != 0 || cur != 0) {
            if (cur == 0) ans += (high * digit);
            else if (cur == 1) ans += (high * digit + low + 1);
            else ans += ((high + 1) * digit);

            low += (cur * digit);
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T043().countDigitOne(35678));
    }
}
