package leetCode.滑动窗口;

public class leetCode_713_乘积小于K的子数组 {
    public static void main(String[] args) {
        int[] nums = {10, 5, 6, 2};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        /**
         * @param cnt: 中间结果
         * @param res: 最终结果
         * @param left: 左指针 用来判断左窗口位置
         * @param right: 右指针 --不断向右移动
         * */

        if (k <= 1) {
            return 0;
        }
        int n = nums.length;
        int cnt = 1, left = 0, res= 0;
        for (int right = 0; right < n; right++) {
            cnt *= nums[right];
            while (cnt >= k) {
                cnt /= nums[left++];
            }
            //核心点-----------------
            res += right - left + 1;
        }
        return res;

    }
}
