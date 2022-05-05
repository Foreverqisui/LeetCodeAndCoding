package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 剑指Offer_015_字符串中的所有变位词 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    private static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        if (p.length() > s.length()) {
            return result;
        }
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int slow = 0, fast = 0, counter = map.size();
        while(fast<s.length()) {
            char c = s.charAt(fast);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    counter--;
                }
            }
            fast++;

            while (counter == 0) {
                char temp = s.charAt(slow);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) >0) {
                        counter++;
                    }
                }
                if (fast - slow == p.length()) {
                    result.add(slow);
                }
                slow++;
            }
        }
        return result;
    }

}
