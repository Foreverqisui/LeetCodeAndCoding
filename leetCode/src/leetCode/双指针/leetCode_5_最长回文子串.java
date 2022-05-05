package leetCode.双指针;

public class leetCode_5_最长回文子串 {
    public static void main(String[] args) {
        String s = "abacabab";
        System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i / 2, right = i / 2 + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                String max = s.substring(left, right+1);
                if (max.length() > res.length()) {
                    res = max;
                }
                --left;
                ++right;
            }

        }
        return res;
    }
}
