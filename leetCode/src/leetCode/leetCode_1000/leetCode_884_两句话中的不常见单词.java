package leetCode.leetCode_1000;

import java.util.*;

public class leetCode_884_两句话中的不常见单词 {
    public static void main(String[] args) {
        String s1 = "apple apple", s2 = "banana";
        System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));
    }

    private static String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] s = s1.split(" ");
        String[] s3 = s2.split(" ");
        for (String c : s) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (String c : s3) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<String> res = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value == 1) {
                res.add(key);
            }
        }
        return res.toArray(new String[0]);
    }

}
