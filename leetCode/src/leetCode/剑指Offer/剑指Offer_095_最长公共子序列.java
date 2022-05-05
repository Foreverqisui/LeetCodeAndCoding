package leetCode.剑指Offer;

import java.util.*;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 *     例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 *
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * */
public class 剑指Offer_095_最长公共子序列 {
    public static void main(String[] args) {
        String text1 = "abcde",text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
    private static int longestCommonSubsequence(String s1, String s2) {
            //dp转移方程
            //如果相等 dp[i][j] = dp[i-1][j-1]+1;
            //如果不相等 dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            int m = s1.length(),n=s2.length();
            //构建dp矩阵
            int [][] dp = new int[m+1][n+1];
            //遍历
            for(int i=1;i<=m;i++){
                //获得s1的字符
                char c1 = s1.charAt(i-1);
                for(int j=1;j<=n;j++){
                    //获得s2的字符
                    char c2 = s2.charAt(j-1);
                    if(c1==c2){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            return dp[m][n];
    }
}
