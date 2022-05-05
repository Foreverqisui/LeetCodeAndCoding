package leetCode.剑指Offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，
 * 且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 */

public class 剑指Offer_116_省份数量 {
    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Solution sol = new Solution();
        System.out.println(sol.findCircleNum(isConnected));
        System.out.println(sol.bfs(isConnected));
    }

    static class Solution {
        /**
         * dfs深搜
         */
        public int findCircleNum(int[][] isConnected) {
            //城市数量
            int cites = isConnected.length;
            //是否被搜索过
            boolean[] visted = new boolean[cites];
            //省份数量
            int province = 0;
            //dfs搜索
            for (int i = 0; i < cites; i++) {
                //如果此城市没被搜所过--就证明有一个省份
                if (!visted[i]) {
                    //搜他
                    dfs(isConnected, cites, visted, i);
                    province++;
                }
            }
            return province;
        }

        private void dfs(int[][] isConnected, int cites, boolean[] visted, int index) {
            for (int i = 0; i < cites; i++) {
                //如果搜到了其他城市，做标记
                if (!visted[i] && isConnected[index][i] == 1) {
                    visted[i] = true;
                    dfs(isConnected, cites, visted, i);
                }
            }
        }

        /**
         * bfs广搜
         */
        public int bfs(int[][] isConnected) {
            //队列模拟 -bfs必备
            Deque<Integer> deque = new LinkedList<Integer>();
            //搜索标志 省份数量 城市数量
            int cities = isConnected.length, province = 0;
            boolean[] visted = new boolean[cities];
            //bfs搜素
            for (int i = 0; i < cities; i++) {
                if (!visted[i]) {
                    deque.offer(i);
                    while (!deque.isEmpty()) {
                        int temp = deque.poll();
                        visted[temp] = true;
                        for (int j = 0; j < cities; j++) {
                            if (!visted[j] && isConnected[temp][j] == 1) {
                                deque.offer(j);
                            }
                        }
                    }
                    province++;
                }
            }
            return province;
        }
    }
}
