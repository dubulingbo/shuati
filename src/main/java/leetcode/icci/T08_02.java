package leetcode.icci;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author DubLBo
 * @since 2020-10-27 10:57
 * i believe i can i do
 */
public class T08_02 {

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {

        boolean hasPath = false;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];

        queue.add(new int[]{0,0});

        while(!queue.isEmpty()){

            for(int i=queue.size();i>0;i++){
                int[] pos = queue.poll();

            }
        }
        return null;
    }
}
