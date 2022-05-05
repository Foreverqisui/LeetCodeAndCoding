package leetCode.动态规划;

public class leetCode_413_等差数列划分 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 7};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    private static int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        if (nums.length < 3) {
            return 0;
        }
        for (int i = 2; i < nums.length; i++) {
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]) {
                dp[i] =dp[i-1]+1;
                res+=dp[i];
            }
        }
        return res;
    }
}
