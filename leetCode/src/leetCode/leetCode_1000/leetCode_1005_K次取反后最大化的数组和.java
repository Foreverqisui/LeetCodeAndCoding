package leetCode.leetCode_1000;

import java.util.Arrays;

public class leetCode_1005_K次取反后最大化的数组和 {
    public static void main(String[] args) {
        int k = 1;
        int[] nums = {1, 3, -1, 0, 4};
        System.out.println(largestSumAfterKNegations(nums, k));
    }

    private static int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);
        return sum - (k % 2 == 0 ? 0 : nums[0] * 2);
    }
}
