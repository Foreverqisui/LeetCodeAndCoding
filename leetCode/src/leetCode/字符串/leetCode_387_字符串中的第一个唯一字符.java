package leetCode.字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetCode_387_字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar1(s));
    }


    /**
     * 哈希表两次遍历
     */
    private static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            /**
             * @param ch:作为键值，通过getOrDefault判断存储元素个数，之后二次遍历得到为1的值
             * */
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 用数组代替哈希表进行两次遍历
     * */
    private static int firstUniqChar1(String s) {
        char[] cs = s.toCharArray();
        char[] chars = new char[128];
        for (int i = 0; i < cs.length; i++) {
            chars[cs[i]]++;
        }
        for (int i = 0; i < cs.length; i++) {
            if (chars[cs[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
