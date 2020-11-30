package leetcode.problems;

import java.util.HashMap;

public class T166 {
    // 分数到小数
    public String fractionToDecimal(int numerator, int denominator) {
        // 模拟
        if (numerator == 0 || denominator == 0) return "0";
        StringBuilder intSb = new StringBuilder();
        long a = numerator, b = denominator;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            // 异号
            intSb.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);

        if (a % b == 0) {
            intSb.append(a / b);
        } else {
            // 有小数部分
            intSb.append(a / b).append(".");
            a %= b;


            // 模拟小数的除法
            // 记录当前小数位的下标
            int index = 0;
            StringBuilder decSb = new StringBuilder();
            // 记录每一位被除数下对应的索引
            HashMap<Long, Integer> map = new HashMap<>();
            // 记录开始重复小数位的下标
            int repeatStart = -1;
            while (a != 0 && index < 10000) {
                // 小数除法可以免费在被除数末尾加一个 0，即乘以 10，
                a *= 10;
                // 记录当前被除数，便于查出循环小数位
                if (map.containsKey(a)) {
                    // 开始出现循环小数位了，循环位为 [map.get(numerator),index - 1]，应该终止运算
                    repeatStart = map.get(a);
                    break;
                } else {
                    map.put(a, index);
                }
                decSb.append(a / b);
                a %= b;
                index++;
            }
            if (repeatStart != -1) {
//                System.out.println(repeatStart + " --> " + (index - 1) + "  ==>  " + decSb.toString());
                intSb.append(decSb.substring(0, repeatStart)).append('(').append(decSb.substring(repeatStart)).append(')');
            } else {
                intSb.append(decSb);
            }
        }
        return intSb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T166().fractionToDecimal(4, 333));
        System.out.println(new T166().fractionToDecimal(2, 3));
        System.out.println(new T166().fractionToDecimal(1, 3));
        System.out.println(new T166().fractionToDecimal(2, 1));
        System.out.println(new T166().fractionToDecimal(1, 2));
        System.out.println(new T166().fractionToDecimal(-1, -2147483648));
    }
}
