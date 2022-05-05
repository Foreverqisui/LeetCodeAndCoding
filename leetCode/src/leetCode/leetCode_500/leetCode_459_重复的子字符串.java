package leetCode.leetCode_500;

public class leetCode_459_重复的子字符串 {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
        System.out.println(repeatedSubstringPattern1(s));
    }

    /**
     * 示例 1
     * 输入: s = "abab"
     * 输出: true
     * 解释: 可由子串 "ab" 重复两次构成。
     */
    private static boolean repeatedSubstringPattern1(String s){
        int n  = s.length();
        for (int i = 1; i <= n/2; i++) {
            if (n%i==0){
                boolean temp = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        temp = false;
                        break;
                    }
                }
                if (temp){
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean repeatedSubstringPattern(String s) {
       boolean res = true;
       String ss = s+s;
       res = ss.substring(1,ss.length()).contains(s);
       return res;
    }
}
