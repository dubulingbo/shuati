package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-10 21:49
 * i believe i can i do
 */
public class T125 {
    // 125. 验证回文串
    // 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    public boolean isPalindrome(String s) {
        // 双指针
        if (s.equals("")) return true;
        char[] chs = s.toUpperCase().toCharArray();
        int left = 0, right = chs.length - 1;
        while (left <= right) {
            if (chs[left] < '0' || chs[left] > 'Z' || (chs[left] < 'A' && chs[left] > '9')) {
                left++;
            } else if (chs[right] < '0' || chs[right] > 'Z' || (chs[right] < 'A' && chs[right] > '9')) {
                right--;
            } else if (chs[left] == chs[right]) {
                left++;
                right--;
            } else {
                break;
            }
        }
        return left > right;
    }

    public static void main(String[] args) {
        System.out.println(new T125().isPalindrome("A    man,,,,,,,, a plan, a canal: Panama   "));
        System.out.println(new T125().isPalindrome("race a car"));
        System.out.println(new T125().isPalindrome(""));
        System.out.println(new T125().isPalindrome("0P"));
        System.out.println(new T125().isPalindrome("aa"));
    }
}
