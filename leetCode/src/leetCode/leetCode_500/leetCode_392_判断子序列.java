package leetCode.leetCode_500;

public class leetCode_392_判断子序列 {
    public static void main(String[] args) {
        String s = "aaaaaa";
        String t = "bbaaaa";
        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequence(String s, String t) {
        int sum = s.length();
        int temp = t.length();
        int m = 0;
        int n = 0;
        while (m < sum && n < temp) {
            if (s.charAt(m) == t.charAt(n)) {
                m++;
            }
                n++;

        }
        return m == sum;
    }
}
