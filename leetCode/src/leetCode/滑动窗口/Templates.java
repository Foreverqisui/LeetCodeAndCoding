package leetCode.滑动窗口;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author foreverqisui
 */
public class Templates {

    public List<Integer> sildingWindowsTemplates(String s, String t) {
        /**
         * @getOrDefault(key,defaultValue):返回指定键映射到的值，如果此映射不包含该键的映射，则返回defaultValue。
         * @containsKey：如果此映射包含指定键的映射，则返回true。
         * @param result:初始化一个集合用来保存结果
         * @param map:创建一个集合用来保存满足要求的字符(k:Character v:字符出现的次数)
         * @param counter:维护一个计数器来检查是否匹配目标字符串
         * @param begin:窗口的左指针
         * @param end:窗口的右指针
         * @param len:匹配目标字符串的子字符串的长度。
         * @param 大概步骤：1.创建result 2.创建map 3.创建计数器 双指针 4.用end指针遍历源字符串 5.用begin指针再次遍历
         */
        List<Integer> result = new LinkedList<Integer>();
        if (t.length() > s.length()) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            //将匹配字符串的值放入map中，如果存在则+1，不存在则为零，存在多个则>1,以此来作为判断依据
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //因为字符串可能重复，所以不能使用字符串的长度
        int counter = map.size();
        int begin = 0, end = 0;
        int len = Integer.MAX_VALUE;
        //从源字符串开始循环
        while (end < s.length()) {
            char c = s.charAt(end);
            //如果map中包含对应值的键则将键对应的值减一
            //如果key对应的值等于零，证明此字符不存在，计数器减一(加一)
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    counter--;
                }
            }
            end++;
            //增加开始指针，使他再一次有效或者无效
            //两个指针用来不断的维护counter
            //每次进行保存或者更新操作
            while (counter == 0) {
                char temp = s.charAt(begin);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0) {
                        counter++;
                    }
                }

                begin++;
            }
        }
        return result;
    }
}