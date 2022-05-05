package leetCode.动态规划;

/**
 * 买卖股票的最佳机会
 */
public class leetCode_126_买卖股票的最佳机会 {
    public static void main(String[] args) {
        int[] nums = {7, 3, 5, 1, 1, 9};
        System.out.println(maxProfit(nums));
    }

    private static int maxProfit(int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] - min > max) {
                max = nums[i] - min;
            }

        }
        return max;
    }
}
