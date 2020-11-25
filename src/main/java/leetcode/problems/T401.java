package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class T401 {
    public List<String> readBinaryWatch(int num) {
        // 直接暴力
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num)
                    times.add(String.format("%d:%02d", h, m));
            }
        }
        return times;
    }

    public static void main(String[] args) {
        System.out.println(new T401().readBinaryWatch(3));
    }
}
