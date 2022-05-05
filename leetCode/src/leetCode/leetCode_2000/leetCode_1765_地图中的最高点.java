package leetCode.leetCode_2000;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class leetCode_1765_地图中的最高点 {
    public static void main(String[] args) {
        int [][] isWater = {{0,0,1},{1,0,0,},{0,0,0}};
        System.out.println(Arrays.deepToString(highestPeak(isWater)));
    }
    private static int[][] highestPeak(int[][] isWater) {
        int m= isWater.length,n=isWater[0].length;
        int [][] res = new int[m][n];
        Deque<int []> deque = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j]==1){
                    //将水域放在队列的开始
                    deque.addLast(new int[]{i,j});
                }
                //如果是水域则存入0，否则存入-1
                res[i][j]=isWater[i][j]==1?0:-1;
            }
        }
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        // 初始高度（和水域相邻的点最高只能为1）
        int h = 1;
        while (!deque.isEmpty()) {
            // 当前队列的大小，因为遍历中要往队列里添加元素（下一层），这样写是必要的（避免当前层和下一层的遍历混淆）
            int size = deque.size();
            while (size-- > 0) {
                int[] info = deque.pollFirst();
                int x = info[0], y = info[1];
                for (int[] di : dirs) {
                    int nx = x + di[0], ny = y + di[1];
                    // 下一个点出界了
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    // 下一个点被访问过了
                    if (res[nx][ny] != -1) {
                        continue;
                    }
                    // 目前是bfs到nx，ny这个点最近的方式了，也就是该点最高的高度
                    res[nx][ny] = h;
                    // 作为下一层遍历的元素入队
                    deque.addLast(new int[]{nx, ny});
                }
            }
            // 陆地高度逐级累加
            h++;
        }
        return res;
    }
}
