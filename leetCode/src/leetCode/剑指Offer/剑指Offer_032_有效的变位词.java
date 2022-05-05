package leetCode.剑指Offer;

import java.util.*;

public class 剑指Offer_032_有效的变位词 {
    public static void main(String[] args) {
        String s = "a", t = "a";
        System.out.println(isAnagram(s, t));
    }
    /**
     * 数组计数
     */
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int i2 = table[t.charAt(i) - 'a'];
            i2--;
            int i1 = i2;
            if (i1 < 0) {
                return false;
            }
        }
        return true;
    }

}
