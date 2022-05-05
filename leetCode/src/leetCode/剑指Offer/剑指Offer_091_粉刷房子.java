package leetCode.剑指Offer;

/**
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，
 * 你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 *
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。
 * 每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 *
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 *
 * 请计算出粉刷完所有房子最少的花费成本。
 *
 * 输入: costs = [[3,5,3],[6,17,6],[7,13,18],[9,10,18]]
 * 输出: 26
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 *      最少花费: 2 + 5 + 3 = 10。
 * */
public class 剑指Offer_091_粉刷房子 {
    public static void main(String[] args) {
        int [][] costs = {{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
        System.out.println(minCost(costs));
    }
    private static int minCost(int[][] costs) {
        int row = costs.length,col = costs[0].length;
        //构建二维矩阵
        int [][] dp = new int[row][col];
        //二维矩阵放入第一个元素
        //总共就三列，逐行走即可
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i =1;i<row;i++){
            //题目要求：相邻的房子不能颜色相同，所以可以间隔操作
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+costs[i][2];
        }
        //找到最后一行的最小值
        return Math.min(dp[row-1][0],Math.min(dp[row-1][1],dp[row-1][2]));
    }
}
