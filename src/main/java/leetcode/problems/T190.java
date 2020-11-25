package leetcode.problems;

import java.util.Collections;

/**
 * @author DubLBo
 * @since 2020-11-09 15:12
 * i believe i can i do
 */
public class T190 {
    // 190. 颠倒二进制位
    // 颠倒给定的 32 位无符号整数的二进制位。
    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0;i<32;i++){
            ans = (ans << 1) + ((n >>> i) & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T190().reverseBits(-3));
    }
}
