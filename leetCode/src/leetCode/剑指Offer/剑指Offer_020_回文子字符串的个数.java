package leetCode.剑指Offer;

public class 剑指Offer_020_回文子字符串的个数 {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
    private static int countSubstrings(String s) {
        int len=s.length(),res=0;
        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i/2,right=i/2+i%2;
            while (left>=0&&right<len&&s.charAt(left) == s.charAt(right)){
                --left;
                ++right;
                ++res;
            }
        }
        return res;
    }
}
