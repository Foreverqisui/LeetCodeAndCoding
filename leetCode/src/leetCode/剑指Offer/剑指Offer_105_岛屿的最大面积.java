package leetCode.剑指Offer;

/**
 * 给定一个由 0 和 1 组成的非空二维数组 grid ，用来表示海洋岛屿地图。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * 输入: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出: 6
 * 解释: 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 * 输入: grid = [[0,0,0,0,0,0,0,0]]
 * 输出: 0
 * */
public class 剑指Offer_105_岛屿的最大面积 {
    public static void main(String[] args) {
        int [][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        Solution sol = new Solution();
        System.out.println(sol.maxAreaOfIsland(grid));
    }
    static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            //dfs求解 -- 依次遍历四个方向，记录数量，返回结果
            int m = grid.length,n=grid[0].length;
            int res =0;
            //dfs开始遍历
            for(int i=0;i< m;i++){
                //注意：此处是不等于m
                for(int j=0;j<n;j++){
                    //选取最大值
                    res = Math.max(res,dfs(grid,i,j));
                }
            }
            return res;
        }
        public int dfs(int [][] grid,int row,int col){
            //递归 -- 第一步 终止条件
            //首先是边界位置 --以0作为标记 代表这个地方曾经访问过，且不可用，防止重复寻找
            if(row<0 || col <0 || row==grid.length || col==grid[0].length){
                return 0;
            }
            //其次是 海洋位置
            if(grid[row][col]!=1){
                return 0;
            }
            //接下来进入dfs流程
            int ans = 1;
            //已经访问过得位置 进行标记
            grid[row][col]=0;
            //核心思想是 -- 四个方向分别寻找
            //方向改变 -- 借助两个数组
            //横向移动
            int [] cRow = {0,0,1,-1};
            //纵向移动
            int [] cCol = {1,-1,0,0};
            //dfs四个方向 并记录
            for(int i=0;i<4;i++){
                //新的横向位置
                int newRow = cRow[i]+row;
                //新的纵向位置
                int newCol = cCol[i]+col;
                //递归调用函数
                ans+=dfs(grid,newRow,newCol);
            }
            return ans;
        }
    }
}
