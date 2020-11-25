package leetcode.problems;

public class T383 {
    // 383. 赎金信
    public boolean canConstruct01(String ransomNote, String magazine) {
        int[] alphaTab = new int[26];
        for (char c : magazine.toCharArray()) {
            alphaTab[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (alphaTab[c - 'a'] < 1) return false;
            alphaTab[c - 'a']--;
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // indexOf(ch, start)，每次查找完更新 start 的值，这样就实现了多个相同字符的查找
        // 存储下一个在 magazine 查找的开始位置（下标），开始应该从第一个字符开始查找，即 0
        int[] nextIdx = new int[26];

        for (char ch : ransomNote.toCharArray()) {
            int curIdx = magazine.indexOf(ch, nextIdx[ch - 'a']);

            // magazine 不存在该字符，直接返回 false
            if (curIdx != -1) return false;

            // 更新下一次查找相同字母的开始位置：即为当前位置的下一个位置
            nextIdx[ch - 'a'] = curIdx + 1;
        }

        return true;
    }
}
