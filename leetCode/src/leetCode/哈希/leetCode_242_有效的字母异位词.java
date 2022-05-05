package leetCode.哈希;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetCode_242_有效的字母异位词 {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram1(s,t));
    }


    /**
     * 哈希表
     * */
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)-1);
            if (map.get(c)<0){
                return false;
            }
        }
        return true;
    }


    /**
     * 用数组方式
     * */
    private static boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int n = s.length();
        int[] num = new int[26];
        for (int i = 0; i < n; i++) {
            num[s.charAt(i) - 'a']++;
            num[t.charAt(i) - 'a']--;
        }
        for (int a : num
        ) {
            if (a != 0) {
                return false;
            }
        }
        return true;
    }
}
