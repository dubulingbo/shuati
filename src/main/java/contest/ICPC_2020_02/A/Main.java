package contest.ICPC_2020_02.A;

import java.util.Scanner;

/**
 * @author DubLBo
 * @since 2020-10-31 12:32
 * i believe i can i do
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();

            // 记录 0,2 出现的次数
            int num0 = 0;
            int num2 = 0;

            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '0') num0++;
                if (s.charAt(i) == '2') num2++;
            }

            int minNum = Math.min(num0, num2);
            int d = Math.abs(num0 - num2);
            System.out.println(minNum / 2 + d);
        }
    }
}
