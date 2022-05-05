package leetCode.剑指Offer;

import java.util.Arrays;

public class 剑指Offer_09_乘积小于K的子数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 0;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            sum *= nums[i];
            while (sum >= k) {
                sum /= nums[left++];
            }
            res += i - left + 1;
        }
        return res;
    }

}
