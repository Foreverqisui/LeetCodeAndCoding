package leetCode.排序;

import java.util.Arrays;

public class leetCode_389_找不同 {
    public static void main(String[] args) {
        String s = "abcdefg";
        String t = "abcdefgi";
        System.out.println(findTheDifference(s, t));
        System.out.println(findTheDifference2(s,t));
    }

    /**
     * 大神的写法
     */
    private static char findTheDifference2(String s, String t) {
        int c = t.charAt(s.length());
        for (int i = 0; i < s.length(); i++) {
            c -= (int) (s.charAt(i));
            c += (int) (t.charAt(i));
        }
        return (char)c;

    }
    /**
     * 计数
     */
    private static char findTheDifference(String s, String t) {
        int s1 = s.length();
        int t1 = t.length();
        int[] cnt = new int[26];
        for (int i = 0; i < s1; i++) {
            char c = s.charAt(i);
            cnt[c - 'a']++;
        }
        for (int i = 0; i < t1; i++) {
            char c = t.charAt(i);
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 位运算
     */
    private static char findTheDifference1(String s, String t) {
        int n = t.length();
        char c = t.charAt(n - 1);
        for (int i = 0; i < n - 1; ++i) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
