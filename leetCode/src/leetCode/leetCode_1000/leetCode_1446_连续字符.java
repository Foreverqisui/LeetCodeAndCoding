package leetCode.leetCode_1000;

public class leetCode_1446_连续字符 {
    public static void main(String[] args) {
        String s = "abbccc";
        System.out.println(maxPower(s));
    }

    private static int maxPower(String s) {
        int ans = 1, cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++cnt;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }
}
