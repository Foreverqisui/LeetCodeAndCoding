package leetCode.剑指Offer;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 *
 * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
 *
 * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * */

public class 剑指Offer_088_爬楼梯的最少成本 {
    public static void main(String[] args) {
        int [] cost = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
    /**
     * 基础dp 推导动态方程
     * 由于可以从0或1开始，于是直接从2开始遍历
     * 动态方程：dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])
     * */
    private static int minCostClimbingStairs(int[] cost) {
        int [] dp = new int[cost.length+1];
        dp[0]=dp[1]=0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
    /**
     * 加入滚动数组优化
     * */
    private static int maxCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
