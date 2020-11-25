package leetcode.icci;

/**
 * @author DubLBo
 * @since 2020-10-26 22:51
 * i believe i can i do
 */
public class T05_07 {
    // 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
    public int exchangeBits(int num) {
//        char[] chs = Integer.toBinaryString(num).toCharArray();
//
//        for(int i = 0;i<chs.length;i+=2){
//            char c = chs[i];
//            chs[i] = chs[i+1];
//            chs[i+1] = c;
//        }
        //奇数
        int odd = num & 0x55555555;
        //偶数
        int even = num & 0xaaaaaaaa;
        odd = odd << 1;
        even = even >>> 1;
        return odd | even;
    }
}
