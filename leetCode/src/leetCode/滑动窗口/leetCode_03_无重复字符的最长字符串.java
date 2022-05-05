package leetCode.滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长字符串
 */
public class leetCode_03_无重复字符的最长字符串 {
    public static void main(String[] args) {
        String s = "abcabcabcd";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int fast = -1;
        int ans = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                characterSet.remove(s.charAt(i - 1));
            }

            //寻找不重复的字符
            while (fast + 1 < length && !characterSet.contains(s.charAt(fast + 1))) {
                characterSet.add(s.charAt(fast + 1));
                fast++;
            }
            //记录最大长度
            ans = Math.max(ans, fast - i + 1);
        }
        return ans;
    }
}
