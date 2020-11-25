package leetcode.icci;

/**
 * @author DubLBo
 * @since 2020-10-26 22:19
 * i believe i can i do
 */
public class T05_06 {
    public int convertInteger(int A, int B) {
        // 可能存在负数，此方法行不通

        // 判断符号位
        boolean flag = true;
        if (A < 0) flag = !flag;
        if (B < 0) flag = !flag;
        int ans = 0;
        A = Math.abs(A);
        B = Math.abs(B);
        while (A != 0 || B != 0) {
            if ((A & 1) + (B & 1) == 1) {
                ans++;
            }
            A >>= 1;
            B >>= 1;
        }

        return ans;
    }

    public int convertInteger_01(int A, int B) {
//        char[] chs = Integer.toBinaryString(A ^ B).toCharArray();
//        int ans = 0;
//        for (char c : chs) {
//            ans += (c == '1' ? 1 : 0);
//        }
//        return ans;


        // 秒喵喵喵喵喵喵！！！！
        int temp = A ^ B;
        int count = 0;
        while (temp != 0) {
            temp &= (temp - 1);  // 去掉二进制表示的最右边的1
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(new T05_06().convertInteger(29, 15));
//        System.out.println(new T05_06().convertInteger(1, 2));

        int a = (29 ^ 15);
        System.out.println(Integer.toBinaryString(a));
    }
}
