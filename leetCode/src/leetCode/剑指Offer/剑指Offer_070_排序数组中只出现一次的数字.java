package leetCode.剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * */
public class 剑指Offer_070_排序数组中只出现一次的数字 {
    public static void main(String[] args) {
        int [] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
    private static int singleNonDuplicate(int[] nums) {
        // 二分查找
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
}
