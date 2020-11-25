package leetcode.icci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DubLBo
 * @since 2020-11-02 16:09
 * i believe i can i do
 */
public class T16_15 {

    public int[] masterMind(String solution, String guess) {
        // 先计算猜中的次数，再计算“伪猜中”次数
        int num1 = 0;
        int num2 = 0;

        // 记录未猜中中的字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = guess.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char key = solution.charAt(i);
            if (chs[i] == key) {
                num1++;
                // 标记为已经猜中的，为之后的伪猜中的次数计算做准备
                chs[i] = '#';
            } else {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        for (char ch : chs) {
            int occurTimes = map.getOrDefault(ch, 0);
            if (occurTimes > 0) {
                // 表示猜中了颜色，但是槽位不对
                num2++;
                map.put(ch, occurTimes - 1);
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T16_15().masterMind("RGBY", "GGRR")));
    }
}
