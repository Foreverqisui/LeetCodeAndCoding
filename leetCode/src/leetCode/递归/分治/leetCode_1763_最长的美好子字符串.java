package leetCode.递归.分治;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

/**
 * @author foreverqisui
 */
public class leetCode_1763_最长的美好子字符串 {
    public static void main(String[] args) {
        String s = "dDzeE";
        System.out.println(longestNiceSubstring(s));
    }


    /**
     * 分治
     * 本题思路：遍历字符串，存储到哈希表内，再次遍历，根据大小写判断是否存在，返回长的美好字符串
     * */
    private static String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : ch) {
            set.add(c);
        }
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            //如果碰到大小写则跳到下一个
            if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) {
                continue;
            }
            /**
             * @param sub1:0到i的美好字符串长度 -- 中间有隔断字母
             * @param sub2:i+1到最后的美好字符串长度
             * */
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i + 1));
            return sub1.length() >=sub2.length() ? sub1 : sub2;
        }
        return s;

    }
}
