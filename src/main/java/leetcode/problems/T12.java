package leetcode.problems;

public class T12 {
    // 12. 整数转罗马数字
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // 记录是否有千位
//        int qNum = num / 1000;
//        sb.append(String.format("%0" + qNum + "d",0).replace("0", "M"));
//        num  = num % 1000;
        int dd = 1000;
        int d = 3;
        while (num > 0) {
            int k = num / dd;
            sb.append(helper(k, d));
            num %= dd;
            dd /= 10;
            d--;
        }

//        System.out.println(sb.toString());
        return sb.toString();
    }

    private String helper(int k, int dd) {
        char[] tt = {'I', 'V', 'X', 'L', 'C', 'D', 'M', 0, 0};
        int stIdx = dd * 2;
        // high: stIdx + 2  mid: stIdx + 1   low: stIdx
        StringBuilder sb = new StringBuilder();
        switch (k) {
            case 1:
                sb.append(tt[stIdx]);
                break;
            case 2:
                sb.append(tt[stIdx]).append(tt[stIdx]);
                break;
            case 3:
                sb.append(tt[stIdx]).append(tt[stIdx]).append(tt[stIdx]);
                break;
            case 4:
                sb.append(tt[stIdx]).append(tt[stIdx + 1]);
                break;
            case 5:
                sb.append(tt[stIdx + 1]);
                break;
            case 6:
                sb.append(tt[stIdx + 1]).append(tt[stIdx]);
                break;
            case 7:
                sb.append(tt[stIdx + 1]).append(tt[stIdx]).append(tt[stIdx]);
                break;
            case 8:
                sb.append(tt[stIdx + 1]).append(tt[stIdx]).append(tt[stIdx]).append(tt[stIdx]);
                break;
            case 9:
                sb.append(tt[stIdx]).append(tt[stIdx + 2]);
            default:
                break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T12().intToRoman(3999));
        System.out.println(new T12().intToRoman(3));
        System.out.println(new T12().intToRoman(4));
        System.out.println(new T12().intToRoman(9));
        System.out.println(new T12().intToRoman(58));
        System.out.println(new T12().intToRoman(1994));
    }
}
