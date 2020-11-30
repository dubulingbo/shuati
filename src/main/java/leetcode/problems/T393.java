package leetcode.problems;

public class T393 {
    // 393. UTF-8 编码验证
    public boolean validUtf8(int[] data) {
        // 当前 utf8 字符的字节数量
        int numOfUtf8Char = 0;

        for (int i = 0; i < data.length; i++) {
            // 获取 data[i] 二进制位中的最低八位
            if (numOfUtf8Char == 0) {
                for (int j = 7; j > 0; j--) {
                    if (((data[i] >> j) & 1) == 0) break;
                    numOfUtf8Char++;
                }
                // 当前位一字节的 UTF-8 字符
                if (numOfUtf8Char == 0) continue;

                // 超过了 4 个字节，当前 UTF-8 字符就不合法
                // 一个字节必须以 0 开头
                if (numOfUtf8Char > 4 || numOfUtf8Char == 1) break;

                // 这里应该要减去当前这个字节；
                numOfUtf8Char--;
            } else {
                // 验证 当前 UTF-8 字符的另一些字节，必须以 10 开头
                if (((data[i] >> 7) & 1) == 1 && ((data[i] >> 6) & 1) == 0) numOfUtf8Char--;
                else break;
            }
        }

        return numOfUtf8Char == 0;
    }

    public static void main(String[] args) {
        System.out.println(new T393().validUtf8(new int[]{235, 140, 4}));

        int k = 235;
        System.out.println(Integer.toBinaryString(k));

        for (int i = 7; i > 0; i--) {
            int r = (k >> i) & 1;
//            if()
            System.out.print(r);
        }
        System.out.println();
        System.out.println(((k >> 7) & 1));
        System.out.println(((k >> 6) & 1));
    }
}
