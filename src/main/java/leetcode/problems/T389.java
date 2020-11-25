package leetcode.problems;

public class T389 {
    // 389. 找不同
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for(char ch : s.toCharArray()){
            map[ch - 'a']++;
        }

        for(char c : t.toCharArray()){
            if(map[c - 'a'] == 0) return c;
            map[c - 'a']--;
        }
        return 0;
    }
}
