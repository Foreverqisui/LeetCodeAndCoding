package leetCode.剑指Offer;

/**
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，
 * 那么该字符串是 单调递增 的。
 *
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 s，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 *
 * 返回使 s 单调递增 的最小翻转次数。
 *
 * 输入：s = "00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 * */
public class 剑指Offer_092_翻转字符 {
    public static void main(String[] args) {
        String s = "00110";
        System.out.println(minFlipsMonoIncr(s));
    }
    private static int minFlipsMonoIncr(String s) {
        //构建dp矩阵 -- 一个是末尾为0，一个是末尾为1
        int len = s.length();
        int [][] dp = new int [len][2];
        //末尾为0
        dp[0][0] = s.charAt(0)=='0'?0:1;
        //末尾为1
        dp[0][1] = s.charAt(0)=='1'?0:1;
        for (int i = 1; i < len; i++) {
            //当末尾为0时，前面的都得为0 --通过计数模拟翻转字符串
            dp[i][0] = dp[i-1][0]+s.charAt(i)=='0'?0:1;
            //当末尾为1时，前面的可以有1可以有0
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1])+s.charAt(i)=='1'?0:1;
        }
        return Math.min(dp[len-1][0],dp[len-1][1]);
    }
}
