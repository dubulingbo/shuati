package leetcode.problems;

import java.math.BigInteger;

/**
 * @author DubLBo
 * @since 2020-11-17 10:05
 * i believe i can i do
 */
public class T306 {
    // 306. 累加数
    public boolean isAdditiveNumber(String num) {
        return helper(num, 0, 0, 0, 1);
    }


    /**
     * @param num    原始字符串
     * @param idx    当前处理下标
     * @param preNum 前一个数字
     * @param sum    前面的两个数字之和
     * @param k      当前是处理的第几个数字
     */
    private boolean helper(String num, int idx, long preNum, long sum, int k) {
        // 已经到达原始数组的尾部
        if (idx == num.length()) {
            // 至少要有三个有效数字
            return k > 3;
        }
        for (int i = idx; i < num.length(); i++) {
            long curNum = fetchCurValue(num, idx, i);
            // 剪枝：无效数字
            if (curNum < 0) { // 数据溢出
                continue;
            }
            // 剪枝：至少已经找到了两个数 && 当前数字不等于前面两数之和
            if (k > 2 && curNum != sum) {
                continue;
            }
            // 枚举下一个数
            if (helper(num, i + 1, curNum, preNum + curNum, k + 1)) {
                return true;
            }
        }
        return false;
    }

    private long fetchCurValue(String num, int left, int right) {
        if (left < right && num.charAt(left) == '0') {
            return -1;
        }
        long res = 0;
        while (left <= right) {
            res = res * 10 + num.charAt(left++) - '0';
        }
        return res;
    }

//    private String sum(String a, String b) {
//        return new BigInteger(a).add(new BigInteger(b)).toString();
//    }

    public static void main(String[] args) {
        System.out.println(new BigInteger("273471264982148723198478123847192938128219823908439028493825903279507320570325732875302758239579302758932579302758784725475863547302626432765430503426432980238650328950739823782974398256345928632856023543275362058932753897842305348052438563245632490578423747283473298573285732844444444444444444444444444444444444444444444444444444").add(new BigInteger("23462716412462194912648")).toString());
//        System.out.println(new T306().sum("10011111", 5, "100", "11"));
    }
}
