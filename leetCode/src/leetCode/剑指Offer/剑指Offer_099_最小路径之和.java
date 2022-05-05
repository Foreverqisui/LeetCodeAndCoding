package leetCode.剑指Offer;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，
 * 使得路径上的数字总和为最小。
 *
 * 说明：一个机器人每次只能向下或者向右移动一步。
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * */
public class 剑指Offer_099_最小路径之和 {
    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
    private static int minPathSum(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        //构建dp矩阵
        int [][] dp = new int[row][col];
        //起点位置
        dp[0][0] = grid[0][0];
        //依次放入行列进入dp矩阵
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        //dp最小值移动 -- 取已知dp矩阵中的数据 寻找最优解
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
