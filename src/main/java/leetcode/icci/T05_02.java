package leetcode.icci;

/**
 * @author DubLBo
 * @since 2020-10-26 14:04
 * i believe i can i do
 */
public class T05_02 {
    // 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
    // 如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。
    // 链接：https://leetcode-cn.com/problems/bianry-number-to-string-lcci

    public void printBin(double num) {

        System.out.println(Double.toHexString(num));
        System.out.println(num);

    }

    public static void main(String[] args) {
        new T05_02().printBin(0.625);
    }

}
