package leetCode.leetCode_500;

import java.util.Arrays;

/**
 * 两数之和（输入有序数组）
 */
public class leetCode_167_两数之和 {
    public static void main(String[] args) {
        int nums[] = {0, 2, 3, 4, 8, 9, 55};
        int target = 6;
        System.out.println(Arrays.toString(twoSum1(nums, target)) + "\n" + Arrays.toString(twoSum3(nums, target)) + "\n" + Arrays.toString(twoSum4(nums, target)));
    }

    //复杂度为n的解法 双指针
    private static int[] twoSum3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    //复杂度为nlogn的解法 二分查找
    private static int[] twoSum4(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target - nums[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (nums[mid] > target - nums[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    //复杂度为n方的解法
    private static int[] twoSum1(int[] nums, int target) {
        int temp[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                if (nums[i] + nums[j] == target && i != j) {
                    temp[0] = i + 1;
                    temp[1] = j + 1;
                    if (temp[0] > temp[1]) {
                        int num = temp[0];
                        temp[0] = temp[1];
                        temp[1] = num;
                    }
                }
            }
        }
        return temp;
    }
}
