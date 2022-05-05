package leetCode.二分查找;

public class leetCode_153_寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
        System.out.println(findMin1(nums));
    }

    /**
     * 暴力
     */
    private static int findMin1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
                min = Math.min(min, nums[i]);
        }
        return min;
    }

    /**
     * 二分查找
     */
    private static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
