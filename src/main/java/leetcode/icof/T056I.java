package leetcode.icof;

import java.util.*;

/**
 * @author DubLBo
 * @since 2020-10-16 14:24
 * i believe i can i do
 */
public class T056I {
    public int[] singleNumbers(int[] nums) {
        // hash表
        // 只出现一次的元素 value 等于其所在下标
        Map<Integer, Integer> singleFlag = new LinkedHashMap<>();
        int len = nums.length;
        int [] res = new int[2];
        for (int i = len - 1; i >= 0; i--) {
            if (singleFlag.containsKey(nums[i])) {
                singleFlag.put(nums[i], len);
            } else {
                singleFlag.put(nums[i], i);
            }
        }

        int k = 0;
        for (Map.Entry<Integer,Integer> entry : singleFlag.entrySet()){
            if(entry.getValue() < len){
                res[k++] = entry.getKey();
            }
        }

        return res;
    }

    public int[] singleNumbers_bit(int[] nums) {
        // 分组异或
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public int test(int [] nums){
        int ans = 0;
        for(int i = 0; i < 32; ++i){
            int cnt = 0;
            for(int n : nums){
                // n & 1 << i 的值大于0即为真
                if((n & (1 << i)) > 0) cnt++;
            }
            // 构造只出现一次的那个数字，采用异或的方法生成二进制中的每一位
            if(cnt % 3 == 1) ans ^= (1 << i);
        }
        return ans;
    }




    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T056I().singleNumbers_bit(new int[]{0, 1, 10, 4, 0, 4, 3, 3})));
    }
}
