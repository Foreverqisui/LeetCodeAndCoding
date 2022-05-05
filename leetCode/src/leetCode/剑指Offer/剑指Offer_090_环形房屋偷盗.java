package leetCode.剑指Offer;

/**
 * 一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * */
public class 剑指Offer_090_环形房屋偷盗 {
    public static void main(String[] args) {
        int [] nums = {2,3,2};
        System.out.println(rob(nums));
    }
    private static int rob(int[] nums) {
        int n = nums.length;
        //边界判断
        if (n==0){
            return 0;
        }
        if (n==1){
            return nums[0];
        }
    return 0;
    }
}
