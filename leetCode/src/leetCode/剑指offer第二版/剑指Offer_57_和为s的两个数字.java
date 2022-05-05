package leetCode.剑指offer第二版;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 */
public class 剑指Offer_57_和为s的两个数字 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];
        while (left <= right) {
            int mid = nums[left] + nums[right];
            if (mid > target) {
                right--;
            } else if (mid < target) {
                left++;
            } else {
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            }
        }
        return res;
    }
}
