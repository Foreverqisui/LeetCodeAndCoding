package leetCode.leetCode_500;

import java.util.*;

public class leetCode_438_找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        String s = "abcdabc", p = "abc";
        System.out.println(findAnagrams(s, p));
    }
// 大概步骤：1.创建result 2.创建map 3.创建计数器 双指针 4.用end指针遍历源字符串 5.用begin指针再次遍历

    public static List<Integer> findAnagrams(String s, String t) {
        //初始化
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        List<Integer> result = new LinkedList<Integer>();
        //条件判断
        if (s.length() < t.length()) {
            return result;
        }
        //将需要识别的字符串+1放进map里
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //初始化 计数器 双指针
        int counter = map.size(), begin = 0, end = 0;
        //快指针
        while (end < s.length()) {
            char c = s.charAt(end);
            //条件判断--map中是否包含 s字符串中的元素 -1操作
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                //如果存在这个字符 则将计数器--
                if (map.get(c) == 0) {
                    counter--;
                }
            }
            //快指针移动
            end++;
            //当计数器归零时
            while (counter == 0) {
                char temp = s.charAt(begin);
                //判断 慢指针是否包含该元素 +1操作
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    //发现存在 计数器++
                    if (map.get(temp) > 0) {
                        counter++;
                    }
                }
                //发现快慢指针之差等于 识别目标的长度时 加入结果中
                if (end - begin == t.length()) {
                    result.add(begin);
                }
                //慢指针移动
                begin++;
            }
        }
        return result;
    }
}