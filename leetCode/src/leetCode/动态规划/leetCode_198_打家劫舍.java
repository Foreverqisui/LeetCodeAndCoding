package leetCode.动态规划;

/**
 * 打家劫舍
 */
public class leetCode_198_打家劫舍 {
    public static void main(String[] args) {
        int[] sum = {1,2};
        System.out.println(rob(sum));
    }

    private static int rob(int[] sum) {
        int length = sum.length;
        if (length == 0 || sum == null) return 0;
        if (length == 1) return sum[0];
        int[] dp = new int[length];
        dp[0] = sum[0];
        dp[1] = Math.max(sum[0], sum[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + sum[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
