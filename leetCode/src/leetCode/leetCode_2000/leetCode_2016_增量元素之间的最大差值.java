package leetCode.leetCode_2000;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，
 * 请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。
 * 返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。
 *
 * 输入：nums = [7,1,5,4]
 * 输出：4
 * 解释：
 * 最大差值出现在 i = 1 且 j = 2 时，nums[j] - nums[i] = 5 - 1 = 4 。
 * 注意，尽管 i = 1 且 j = 0 时 ，nums[j] - nums[i] = 7 - 1 = 6 > 4 ，
 * 但 i > j 不满足题面要求，所以 6 不是有效的答案。
 * */
public class leetCode_2016_增量元素之间的最大差值 {
    public static void main(String[] args) {
        int [] nums = {7,1,5,4};
        System.out.println(maximumDifference(nums));
        System.out.println(maximumDifference1(nums));
    }
    /**
     * 暴力
     * */
    private static int maximumDifference1(int[] nums){
     int res =-1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[j]>nums[i]){
                    res = Math.max(res,nums[j]-nums[i]);
                }
            }
        }
        return res;
    }

    /**
     * 前缀和最小值
     * */
    private static int maximumDifference(int[] nums) {
      int res = -1,premin = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > premin){
                res = Math.max(res,nums[i]-premin);
            }else {
                premin=nums[i];
            }
        }
        return res;
    }
}
