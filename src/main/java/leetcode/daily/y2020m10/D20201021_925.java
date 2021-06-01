package leetcode.daily.y2020m10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DubLBo
 * @since 2020-10-21 09:37
 * i believe i can i do
 */
public class D20201021_925 {
    public boolean isLongPressedName_double_ptr(String name, String typed) {
        // 双指针法：此方法更快
        int i = 0, j = 0;
        while (i < typed.length()) {
            if (j < name.length() && name.charAt(j) == typed.charAt(i)) {
                i++;
                j++;
            } else if (i > 0 && typed.charAt(i - 1) == typed.charAt(i)) {
                i++;
            } else {
                // break;
                return false;
            }
        }

        return j == name.length();
    }


    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();

        if (len2 < len1 || len1 == 0) {
            return false;
        }

        List<Integer> list1 = func(name);
        List<Integer> list2 = func(typed);

        if (list1.size() != list2.size()) {
            return false;
        }

        int i = 0;
        int j = 0;
        // 比对每个位置上字符是否相对，并且出现的次数是否正确
        for (int k = 0; k < list1.size(); k++) {
            if (name.charAt(i) != typed.charAt(j) || list2.get(k).compareTo(list1.get(k)) < 0) {
                return false;
            }
            i += list1.get(k);
            j += list2.get(k);
        }
        return true;
    }

    // 统计每个连续出现的字符的次数
    private List<Integer> func(String s) {

        // ass[i] = k 表示字符连续出现的次数
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        res.add(1);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                int cnt = res.get(idx) + 1;
                res.set(idx, cnt);
            } else {
                idx++;
                res.add(1);
            }
        }
        return res;
    }
//    private int[] func(String s) {
//        int idx = 0;
//        // cnt[i] = k 表示字符连续出现的次数
//        cnt[0] = 1;
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i - 1) == s.charAt(i)) {
//                cnt[idx]++;
//            } else {
//                cnt[++idx] = 1;
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new D20201021_925().isLongPressedName("alex", "aaleex"));
        System.out.println(new D20201021_925().isLongPressedName_double_ptr("saeed", "ssaaeddd"));
        System.out.println(new D20201021_925().isLongPressedName("leelee", "lleeelee"));
        System.out.println(new D20201021_925().isLongPressedName_double_ptr("laiden", "laiden"));
        System.out.println(new D20201021_925().isLongPressedName_double_ptr("laiden", "latden"));
    }
}
