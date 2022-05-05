package leetCode.剑指Offer;

/**
 * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * */
public class 剑指Offer_089_房屋偷盗 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
    private static int rob(int[] nums) {
        int n = nums.length;
        //边界判断 --只有一家能偷或者没有能偷的
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        //开始行窃 -- 先做笔记
        int [] dp = new int[n];
        //先踩点前两个，为后续做准备
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        //开始挨家踩点做笔记了
        for(int i=2;i<n;i++){
            //开始挨家做笔记了
            //不断记录，偷最后一家和不偷最后一家哪个值钱
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
