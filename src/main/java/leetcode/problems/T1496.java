package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author DubLBo
 * @since 2020-11-08 13:39
 * i believe i can i do
 */
public class T1496 {
    // 1496. 判断路径是否相交
    public boolean isPathCrossing(String path) {
        Set<String> hash = new HashSet<>();
        hash.add("00");

        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            String s = "" + x + y;
            if (hash.contains(s)) return true;
            else hash.add(s);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T1496().isPathCrossing("NES"));
    }
}
