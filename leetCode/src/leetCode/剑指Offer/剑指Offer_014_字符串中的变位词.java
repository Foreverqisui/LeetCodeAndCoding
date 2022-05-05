package leetCode.剑指Offer;

public class 剑指Offer_014_字符串中的变位词 {
    public static void main(String[] args) {
        String s1 = "adc", s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }

    private static boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < n; right++) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                left++;
            }
            if (right - left + 1 == m) {
                return true;
            }

        }
        return false;
    }

}
