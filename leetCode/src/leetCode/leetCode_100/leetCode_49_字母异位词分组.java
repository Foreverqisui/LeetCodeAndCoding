package leetCode.leetCode_100;

import java.util.*;

public class leetCode_49_字母异位词分组 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> map =new HashMap<String, List<String>>();
        for (String str : strs) {
            char []c =str.toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            /**
             * map.getOrDefault方法就是将new ArrayList<String>()映射到s（键）上
             * 意思就是s为key键 映射的值都是空的字符串
              Returns the value to which the specified key is mapped,
              or defaultValue if this map contains no mapping for the key.
             */
            List<String> l = map.getOrDefault(s,new ArrayList<String>());
            l.add(str);
            map.put(s,l);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
