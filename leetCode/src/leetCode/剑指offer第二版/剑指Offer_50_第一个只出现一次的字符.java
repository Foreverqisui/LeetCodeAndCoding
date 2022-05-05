package leetCode.剑指offer第二版;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * */
public class 剑指Offer_50_第一个只出现一次的字符 {

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }
    private static char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
