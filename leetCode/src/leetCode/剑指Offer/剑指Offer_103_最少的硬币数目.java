package leetCode.剑指Offer;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
public class 剑指Offer_103_最少的硬币数目 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

    }

    class Solution {
        public int dpCoinChange(int [] coins, int amount) {
            //dp做法
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
        public int coinChange(int[] coins, int amount) {
            //记忆化搜索
            if(amount<1){
                return 0;
            }
            //借助数组，存储中间的变量
            return coinChange(coins,amount,new int [amount+1]);
        }
        public int coinChange(int [] coins,int rem,int [] count){
            //递归终止
            if(rem<0){
                return -1;
            }
            if(rem==0){
                return 0;
            }
            //目标值 -- 如果曾经搜过，就可以直接返回
            if(count[rem-1]!=0){
                return count[rem-1];
            }
            //最小变量
            int min = Integer.MAX_VALUE;
            //遍历硬币
            for(int coin:coins){
                //dfs向下搜索 -- 找到符合要求的值
                int res = coinChange(coins,rem-coin,count);
                //
                if(res>=0&&res<min){
                    min = res+1;
                }
            }
            count[rem-1] = (min==Integer.MAX_VALUE)?-1:min;
            return count[rem-1];
        }
    }

}
