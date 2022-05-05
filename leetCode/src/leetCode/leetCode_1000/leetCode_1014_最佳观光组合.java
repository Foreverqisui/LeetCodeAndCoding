package leetCode.leetCode_1000;

/**
 * 最佳观光组合
 */
public class leetCode_1014_最佳观光组合 {
    public static void main(String[] args) {
        int[] nums = {9, 7, 5, 1, 3, 4};
        System.out.println(maxScoreSightseeingPair(nums));
    }

    private static int maxScoreSightseeingPair(int[] nums) {
        int sum = nums[0];
        int temp = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            temp = Math.max(temp, sum + nums[i] - i);
            sum=Math.max(sum,nums[i]+i);
        }
        return temp;
    }
}
