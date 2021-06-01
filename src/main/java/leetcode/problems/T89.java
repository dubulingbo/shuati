package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author habitplus
 * @since 2020-12-19 14:58
 */
public class T89 {
    // 89. 格雷编码
    // 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
    // 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
    // 格雷编码序列必须以 0 开头。
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int dd = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(dd + res.get(j));
            }
            dd <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T89().grayCode(2));
        System.out.println(new T89().grayCode(4));
    }
}
