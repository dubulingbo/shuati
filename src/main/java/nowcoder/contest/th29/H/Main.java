package nowcoder.contest.th29.H;

import java.util.Scanner;

/**
 * @author DubLBo
 * @since 2020-11-14 22:21
 * i believe i can i do
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            long x1 = sc.nextLong();
            long y1 = sc.nextLong();
            long r1 = sc.nextLong();
            long x2 = sc.nextLong();
            long y2 = sc.nextLong();
            long r2 = sc.nextLong();

            if (r1 == 0 || r2 == 0) {
                System.out.println("NO");
                continue;
            }

//            BigInteger x = BigInteger.valueOf(Math.abs(x1 - x2));
//            BigInteger y = BigInteger.valueOf(Math.abs(y1 - y2));
//            BigInteger r = BigInteger.valueOf(r1 + r2);
//            BigInteger dist = x.multiply(x).add(y.multiply(y));
//            r = r.multiply(r);
            long dist = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
            long r0 = (r1 + r2) * (r1 + r2);
            if (dist > r0) System.out.println("NO");
            else if (Math.sqrt(dist) + Math.min(r1, r2) < Math.max(r1, r2)) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
