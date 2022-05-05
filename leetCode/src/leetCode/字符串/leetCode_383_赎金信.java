package leetCode.字符串;

import java.util.HashMap;
import java.util.Map;

public class leetCode_383_赎金信 {
    public static void main(String[] args) {
        String ransomNote = "aab";
        String magazine = "baab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] num = new int[26];
        for (int c : magazine.toCharArray()
        ) {
            num[c - 'a']++;
        }
        for (int c : ransomNote.toCharArray()) {
            if (--num[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


}
