package leetcode.daily.y2020m11;

/**
 * @author DubLBo
 * @since 2020-11-18 11:57
 * i believe i can i do
 */
public class D20201118_134 {
    // 134. 加油站
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 暴力 + 模拟 + 优化
        int n = gas.length;
        // 枚举所有加油站做为起点
        int i = 0;
        while (i < n) {
            // 从第 i 个加油站出发，能到达的加油站个数
            int stationNum = 0;
            // 初始时车箱内的汽油为本加油站的汽油容量
            int leftGas = gas[i];
            // 当前所在的加油站
            int j = i;

            while(stationNum < n){
                // 判断能否到达下一个加油站
                if(leftGas < cost[j]){
                    break;
                } else {
                    // 能到达下一个加油站
                    leftGas -= cost[j];
                    j = (j + 1) % n;
                    leftGas += cost[j];
                    stationNum++;
                }
            }
            // 能绕回来
            if(stationNum == n) return i;
            else{
                // 一点优化
                // 说明 从 i 到 stationNum + i - 1 这些个站中任意一个出发都无法到达 stationNum + i，故，下一枚举可以从第 i + stationNum 个站开始
                i += stationNum;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new D20201118_134().canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
    }
}
