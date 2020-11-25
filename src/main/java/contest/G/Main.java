package contest.G;


/**
 * @author DubLBo
 * @since 2020-10-24 13:21
 * i believe i can i do
 */

import java.util.Scanner;

public class Main {
    private int num = 200;

    public void calc(String s, int mul, int[] res) {
        char[] chs = s.toCharArray();
        int len = chs.length;

        int k = 0;
        int j = num - 1;
        for (int i = len - 1; i >= 0; i--) {
            int tmp = (chs[i] - '0') * mul + k;
            res[j--] = tmp % 10;
            k = tmp / 10;
        }

        while (k > 0) {
            res[j--] = k % 10;
            k /= 10;
        }
    }

    public char test(String x, int a, String y, int b) {
        int[] res1 = new int[num];
        int[] res2 = new int[num];

        calc(x, b, res1);
        calc(y, a, res2);

        for (int i = 0; i < num; i++) {
            if (res1[i] != res2[i]) {
                return res1[i] > res2[i] ? '>' : '<';
            }
        }
        return '=';

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        char[] chs = s.trim().toCharArray();
//        int[] dp = new int[chs.length];
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
