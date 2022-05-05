package leetCode.leetCode_500;

import java.util.*;

/**
 * 单词拆分
 */
public class leetCode_139_单词拆分 {
    public static void main(String[] args) {
        String s = "leetCode";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("le");
        System.out.println(wordBreak(s, wordDict));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <=s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
