package leetCode.leetCode_1000;

/**
 * 买卖股票最佳机会含手续费
 */
public class leetCode_714_买卖股票最佳机会含手续费 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 1, 9, 1};
        System.out.println(maxProfit(nums));
        System.out.println(maxProfit1(nums,2));
    }


    /**
     * 贪心
     */
    private static int maxProfit1(int[] nums,int fee) {
            int n=nums.length;int profit=0;int buy=nums[0]+fee;
        for (int i = 1; i < n; i++) {
            if (nums[i]+fee<buy){
                buy=nums[i];
            }else if (nums[i]>buy){
                profit+=nums[i]-buy;
            }
        }
        return profit;
    }


    /**
     * 动态规划
     */
    private static int maxProfit(int[] nums) {
        int sell = 0;
        int buy = -nums[0];
        int fee = -2;
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            sell = Math.max(sell, nums[i] + buy + fee);
            buy = Math.max(buy, sell - nums[i]);
        }
        return sell;
    }
}
