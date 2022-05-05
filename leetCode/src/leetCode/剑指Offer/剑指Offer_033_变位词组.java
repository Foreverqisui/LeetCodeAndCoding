package leetCode.剑指Offer;

import java.util.*;

public class 剑指Offer_033_变位词组 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups = new HashMap<>();
        for (String str : strs){
            char []c=str.toCharArray();
            //排序 根据字母对应的ASCII码排序
            Arrays.sort(c);
            //转回字符串
            String s = new String(c);
            //如果有相同的就映射到同一个数组里
            List<String> l = groups.getOrDefault(s,new ArrayList<>());
            //将原先顺序的字符串加入到里面；
            l.add(str);
            //如果有相同的就放到同一个数组里
            groups.put(s,l);
        }
        return new ArrayList<>(groups.values());
    }
}
