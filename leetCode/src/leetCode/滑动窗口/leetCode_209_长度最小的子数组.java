package leetCode.滑动窗口;

public class leetCode_209_长度最小的子数组 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        /**
         * @param sum:中间值 不断对中间值进行维护
         * @param left:左指针 用来判断左窗口位置
         * @param i:此时的i就是右指针
         * @param minSize:最小距离
         * */
        int n = nums.length, sum = 0, left = 0;
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            //当sum>=target的时候，证明符合条件 此时减去左窗口位置的数 直到不符合要求
            //不停对窗口进行滑动，直到找到最优解
            while (sum >= target) {
                //核心 -- i+1-left
                minSize = Math.min(minSize, i + 1 - left);
                //减去左窗口的值
                sum -= nums[left];
                //将左窗口的位置右移一
                left++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
