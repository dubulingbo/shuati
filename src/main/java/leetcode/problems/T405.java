package leetcode.problems;

public class T405 {
    // 405. 数字转换为十六进制数
    public String toHex01(int num) {
        // 将整数转化成二进制的字符串
        char[] binaryChs = Integer.toBinaryString(num).toCharArray();
        char[] tab = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int t = 0;
        int d = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = binaryChs.length - 1; i >= 0; i--) {
            t += (binaryChs[i] - '0') * d;
            d *= 2;
            if (i == 0) {
                // 处理最后一位
                sb.append(tab[t]);
                break;
            }
            if (d == 16) {
                sb.append(tab[t]);
                d = 1;
                t = 0;
            }
        }
        return sb.reverse().toString();
    }

    public String toHex(int num) {
        // 位运算
        // 0特殊处理
        if (num == 0) return "0";
        char[] hex = "0123456789abcdef".toCharArray();  // 相当于映射关系
        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            int temp = num & 0xf;   // 取低4位的十进制值
            ans.append(hex[temp]);  // 映射对应字符
            num >>>= 4;             // 逻辑右移4位
        }
        // while的循环条件保证了不会出现前导0
        // 但是从低位开始转换多了一步reverse反转
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new T405().toHex(-1));
        System.out.println(new T405().toHex(26));
    }

}
