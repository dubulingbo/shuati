package leetcode.problems;

/**
 * @author DubLBo
 * @since 2020-11-17 14:09
 * i believe i can i do
 */
public class T1502 {
    // 1502. 判断能否形成等差数列
    public boolean canMakeArithmeticProgression(int[] arr) {
        // if(arr.length < 3) return true;
        // Arrays.sort(arr);
        // int d = arr[1] - arr[0];
        // for(int i = 2; i < arr.length; i++){
        //     if(d != arr[i] - arr[i - 1]){
        //         return false;
        //     }
        // }
        // return true;

        // 记录第一小和第二小的数，方便计算公差
        int firstSmall = Integer.MAX_VALUE, secondSmall = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] < firstSmall){
                secondSmall = firstSmall;
                firstSmall = arr[i];
            }else if(arr[i] < secondSmall){
                secondSmall = arr[i];
            }
        }
        // 计算公差
        int d = secondSmall - firstSmall;
        // HashSet<Integer> set = new HashSet<>();
        // 标记公差的倍数是否只出现一次
        boolean[] multiple = new boolean[arr.length];
        for(int i =0;i<arr.length;i++){
            if(d == 0){
                if(arr[i] != firstSmall) return false;
            } else {
                if((arr[i] - firstSmall) % d != 0) return false;
                int x = (arr[i] - firstSmall) / d;
                // 倍数越界 || 已经在前面出现过了
                if(x >= arr.length || multiple[x]) return false;
                multiple[x] = true;
            }
        }
        // 能循环完一定就是等差数列了
        return true;
    }
}
