package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-12 20:41
 * i believe i can i do
 */
public class T1342 {
    // 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            num = num % 2 == 0 ? num / 2 : num - 1;
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new T1342().numberOfSteps(123));
        System.out.println(new T1342().numberOfSteps(14));
        System.out.println(new T1342().numberOfSteps(8));
    }
}
