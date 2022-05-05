package leetCode.滑动窗口;

public class leetCode_643_子数组最大平均数I {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    /**
     * 滑动窗口
     * */
    private static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        /**
         * @param sum:中间值 表示一个长度为k的窗口
         * @param maxSum:表示长度为k窗口的最大值
         * @param 滑动窗口：通过制定额定长度的数组，每次进行额定步数的移动，从而得到最优值
         * */
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum + nums[i]-nums[i-k];
            maxSum = Math.max(maxSum,sum);
        }
        return 1.0*maxSum/k;
    }
}
