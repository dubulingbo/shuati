package leetcode.daily.y2020m10;

/**
 * @author DubLBo
 * @since 2020-10-19 20:27
 * i believe i can i do
 */
public class D20201019_844 {
    // 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
    public boolean backspaceCompare(String s, String t) {
        char[] validS = new char[s.length()];
        char[] validT = new char[t.length()];

        int len1 = 0, len2 = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '#'){
                if(len1 > 0 ) len1--;
            } else {
                validS[len1++] = s.charAt(i);
            }
        }

        for(int i = 0;i<t.length();i++){
            if(t.charAt(i) == '#'){
                if(len2 > 0) len2--;
            }else{
                validT[len2++] = t.charAt(i);
            }
        }

        return String.valueOf(validS,0,len1).equals(String.valueOf(validT,0,len2));
    }

    public static void main(String[] args) {
        System.out.println(new D20201019_844().backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
