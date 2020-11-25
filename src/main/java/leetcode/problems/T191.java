package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-09 15:36
 * i believe i can i do
 */
public class T191 {
    // 191. 位1的个数
    // 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
    public int hammingWeight(int n) {
        int ans = 0;
        for(int i=0;i<32;i++){
            if(((n>>>i) & 1) == 1) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T191().hammingWeight(-3));
    }
}
