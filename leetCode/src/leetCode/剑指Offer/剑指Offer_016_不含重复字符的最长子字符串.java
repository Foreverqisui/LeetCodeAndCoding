package leetCode.剑指Offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 剑指Offer_016_不含重复字符的最长子字符串 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring1(s));
    }

    private static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0,res=0;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))!=null){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            res = Math.max(res,i-left+1);
        }
        return res;
    }


    private static int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int fast = -1;
        int ans = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                characterSet.remove(s.charAt(i - 1));
            }

            //寻找不重复的字符
            while (fast + 1 < length && !characterSet.contains(s.charAt(fast + 1))) {
                characterSet.add(s.charAt(fast + 1));
                fast++;
            }
            //记录最大长度
            ans = Math.max(ans, fast - i + 1);
        }
        return ans;
    }
}
