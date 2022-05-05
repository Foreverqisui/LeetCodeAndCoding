package leetCode.leetCode_500;


public class leetCode_300_最长递增子序列 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS1(nums));
    }

    /**
     * 二分查找+贪心
     */
    private static int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int[] tail = new int[n + 1];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > tail[end]) {
                end++;
                tail[end] = nums[i];
            } else {
                int l = 0;
                int r = end;
                while (l < r) {
                    int mid = l + ((r - l) >>> 1);
                    if (tail[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tail[l] = nums[i];
            }
        }
        end++;
        return end;
    }


    /**
     * 动态规划
     */
    private static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
