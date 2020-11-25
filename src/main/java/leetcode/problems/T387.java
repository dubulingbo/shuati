package leetcode.problems;

public class T387 {
    // 387. 字符串中的第一个唯一字符
    public int firstUniqChar01(String s) {
        int[] map = new int[26];
        // 建立 hash 映射表
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            map[ch - 'a']++;
        }

        for (int i = 0; i < chs.length; i++) {
            if (map[chs[i] - 'a'] == 1) return i;
        }
        return -1;
    }

    public int firstUniqChar(String s) {
        // 直接枚举 26 个小写字母

        int ans = s.length();

        for(char ch = 'a'; ch <= 'z'; ch++){
            int firstIdx = s.indexOf(ch);
            // 存在该字母，并且 只出现一次
            if(firstIdx != -1 && firstIdx == s.lastIndexOf(ch)){
                ans = Math.min(ans, firstIdx);
            }
        }

        return ans == s.length() ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new T387().firstUniqChar("leetcode"));
        System.out.println(new T387().firstUniqChar("loveleetcode"));
    }

}
