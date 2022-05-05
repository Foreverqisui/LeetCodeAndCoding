package leetCode.二分查找;

public class leetCode_162_寻找峰值 {
    public static void main(String[] args) {
        int [] nums = {1,2,7,8,9,5,1,4,7,9,2};
        System.out.println(findPeakElement(nums));
    }
    private static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int left = 0, right = n - 1;
        while (left<right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
