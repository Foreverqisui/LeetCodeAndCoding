package leetCode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 * */
public class 剑指Offer_107_矩阵中的距离 {
    public static void main(String[] args) {
        int [][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(sol.updateMatrix(mat)));
    }
    static class Solution {
        //负责移动的变量
        static int[][] temp = {{-1,0},{1,0},{0,-1},{0,1}};

        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length,n = mat[0].length;
            //标记是否为0
            boolean [][] flag = new boolean[m][n];
            //用来记录矩阵
            Deque<int []> deque = new ArrayDeque<int[]>();
            //结果数组
            int [][] res = new int[m][n];
            //将为0的位置加入进去
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0){
                        deque.offer(new int[]{i,j});
                        flag[i][j] = true;
                    }
                }
            }
            //bfs
            while(!deque.isEmpty()){
                int [] cell = deque.poll();
                //行列元素--旧位置
                int row = cell[0],col = cell[1];
                //上下左右四个方向移动
                for (int i = 0; i < 4; i++) {
                    //新位置
                    int newRow = row + temp[i][0];
                    int newCol = col + temp[i][1];
                    //边界判断
                    if (newRow>=0 && newCol>=0 && newRow<m && newCol<n && !flag[newRow][newCol]){
                        //拿旧位置的+1 == 新位置
                        res[newRow][newCol] = res[row][col]+1;
                        deque.offer(new int[]{newRow,newCol});
                        flag[newRow][newCol] = true;
                    }
                }
            }
            return res;
        }
    }
}
