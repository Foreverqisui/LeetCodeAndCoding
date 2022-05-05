package leetCode.leetCode_500;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class leetCode_205_同构字符串 {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s, t));
    }

    private static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char m = s.charAt(i);
            char n = t.charAt(i);
            if (map1.containsKey(m) && map1.get(m) != n || map2.containsKey(n) && map2.get(n) != m) {
                return false;
            }
            map1.put(m, n);
            map2.put(n, m);
        }
        return true;

    }
    }
