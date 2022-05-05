package leetCode.双指针;

import java.util.Arrays;

public class leetCode_905_按奇偶排序数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    private static int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 == 1) right--;
        }
        return nums;
    }
}
