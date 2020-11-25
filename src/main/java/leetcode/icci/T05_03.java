package leetcode.icci;

/**
 * @author DubLBo
 * @since 2020-10-26 14:21
 * i believe i can i do
 */
public class T05_03 {
    // 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。

    public int reverseBits(int num) {
        String[] arr = Integer.toBinaryString(num).split("0");
        if (arr.length == 0) {
            return arr.length + 1;
        }
        int maxLen = arr[0].length();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() + arr[i - 1].length() > maxLen) {
                maxLen = arr[i].length() + arr[i - 1].length();
            }
        }

        return maxLen + 1;

    }

    public static void main(String[] args) {
//        new T05_03().reverseBits(6);
//        new T05_03().reverseBits(7);
//        new T05_03().reverseBits(8);
//        new T05_03().reverseBits(255);
//        new T05_03().reverseBits(1775);
    }

}
