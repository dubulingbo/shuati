package leetcode.daily.y2020m12;

import java.util.ArrayList;
import java.util.List;

public class D20201208_842 {
    public List<Integer> splitIntoFibonacci01(String S) {
        // dfs
        List<Integer> ans = new ArrayList<>();
        if (S.length() < 3) return ans;
        char[] chs = S.toCharArray();
        int len = chs.length;
        // 枚举第一个数和第二个数，并且要符合规则
        int num1 = 0;
        for (int i = 0; i < len; i++) {
            num1 = num1 * 10 + chs[i] - '0';
            int num2 = 0;
            for (int j = i + 1; j < len; j++) {
                // 判断能否构成第三个数，两个非负整数的和的位数至少为最大的那个数的位数
                num2 = num2 * 10 + chs[j] - '0';
                int t = Math.max(i + 1, j - i);
                if (len - j - 1 < t) break;
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(num1);
                tmpList.add(num2);
                if (dfs(S, num1, num2, j + 1, tmpList)) {
                    // 找到了一种组合，直接返回
                    return tmpList;
                }
                // 本轮的第一个数字就为 0，则没有必要再循环第二次了
                if (chs[i + 1] == '0') break;
            }
            // 没有必要再循环第二次了
            if (chs[0] == '0') break;
        }
        return ans;
    }

    // 判断以 a，b 为首项，能否让 s 组成斐波拉契数列
    private boolean dfs(String s, int a, int b, int curIdx, List<Integer> tmpList) {
        if (curIdx == s.length()) return true;

        int num = b + a;
        String numStr = Integer.toString(num);
        if (s.indexOf(numStr, curIdx) == curIdx) {
            // 枚举下一个数
            tmpList.add(num);
            // 直接返回
            return dfs(s, b, num, curIdx + numStr.length(), tmpList);
        }
        return false;
    }

    public List<Integer> splitIntoFibonacci(String S) {
        // 回溯 + 剪枝
        List<Integer> ans = new ArrayList<>();
        char[] chs = S.toCharArray();
        if (backtrack(chs, 0, 0, 0, ans)) return ans;
        else return new ArrayList<>();
    }

    private boolean backtrack(char[] chs, int preNum, int sum, int curIdx, List<Integer> ans) {
        if (curIdx == chs.length) return ans.size() >= 3;

        // 枚举第三个数，因为要做越界判断
        long curLong = 0;
        for (int i = curIdx; i < chs.length; i++) {
            // 0 只能作为单个数字， 不能作为前导 0
            if (i > curIdx && chs[curIdx] == '0') break;

            curLong = curLong * 10 + chs[i] - '0';

            // 越界判断
            if (curLong > Integer.MAX_VALUE) break;
            int curNum = (int) curLong;

            // 前面至少有两个数，才可以进行相加判断
            if (ans.size() > 1 && preNum + sum != curNum) continue;

            ans.add(curNum);
            if (backtrack(chs, sum, curNum, i + 1, ans)) {
                return true;
            } else {
                ans.remove(ans.size() - 1);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        String s = "123456579";

        int i = 579;
        System.out.println(new D20201208_842().splitIntoFibonacci("1101111"));
        System.out.println(new D20201208_842().splitIntoFibonacci("123456579"));
        System.out.println(new D20201208_842().splitIntoFibonacci("0123"));
        System.out.println(new D20201208_842().splitIntoFibonacci("112358130"));
        System.out.println(new D20201208_842().splitIntoFibonacci("11235813"));
    }
}
