package contest.ICPC_2020_01.C;

import java.util.Scanner;

/**
 * @author DubLBo
 * @since 2020-10-25 12:58
 * i believe i can i do
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chs = s.trim().toCharArray();
        int k = 0;
        int ans = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'w') {
                k++;
            } else {
                ans += (k == 0 ? 0 : 2 * k - 1);
                k = 0;
            }
        }
        ans += (k == 0 ? 0 : 2 * k - 1);
        System.out.println(ans);

    }

}
