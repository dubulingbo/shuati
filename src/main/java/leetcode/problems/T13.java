package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-13 09:38
 * i believe i can i do
 */
public class T13 {
    public int romanToInt(String s) {
        int sum = 0;
        // 指向前一个字符所代表的数字
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                // 说明小数在大数的左边，此时结果应该减去 preNum
                sum -= preNum;
            } else {
                // 小数在大数的右边，此时结果应该加上 preNum
                sum += preNum;
            }
            preNum = num;
        }
        // 最后一位就是加法
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
