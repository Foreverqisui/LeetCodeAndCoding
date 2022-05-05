package leetCode.leetCode_100;

/**
 * 实现strStr()
 */
public class leetCode_28_实现strStr {
    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        System.out.println(strStr(a, b));
    }

    public static int strStr(String ss, String pp) {
        if (ss.equals("") || pp.equals("")){
            return 0;
        }
        int n = ss.length();
        int m = pp.length();
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        for (int i = 0; i <= n - m; i++) {
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            if (b == m) {
                return i;
            }

        }
        return -1;
    }
}

