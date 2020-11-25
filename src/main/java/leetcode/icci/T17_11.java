package leetcode.icci;

/**
 * @author DubLBo
 * @since 2020-11-03 19:41
 * i believe i can i do
 */
public class T17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        // 双指针
        int ptr1 = -1;
        int ptr2 = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) ptr1 = i;
            if (words[i].equals(word2)) ptr2 = i;
            if (ptr1 != -1 && ptr2 != -1 && ans > Math.abs(ptr1 - ptr2)) {
                ans = Math.abs(ptr1 - ptr2);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new T17_11().findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student"));
    }
}
