package leetcode.problems;

public class T859 {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        // 指向前一个不同位置的下标
        int prev = -1;
        // 标记相同位置上的不同字符数目
        int cnt = 0;
        // 标记 A 是否有相同的字符
        boolean haveSame = false;
        int[] map = new int[26];
        for (int i = 0; i < A.length(); i++) {
            int idx = A.charAt(i) - 'a';
            map[idx]++;
            if (!haveSame && map[idx] > 1) haveSame = true;
            if (A.charAt(i) == B.charAt(i)) continue;
            cnt++;
            if (cnt == 2) {
                // 不能交换则直接返回true
                if (!(A.charAt(prev) == B.charAt(i) && A.charAt(i) == B.charAt(prev))) return false;
            }
            prev = i;
        }

        return (cnt == 2) || (cnt == 0 && haveSame);
    }
}
