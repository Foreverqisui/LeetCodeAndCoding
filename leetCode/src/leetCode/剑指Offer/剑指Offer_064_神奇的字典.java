package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 剑指Offer_064_神奇的字典 {


    class MagicDictionary {

        Map<Integer, ArrayList<String>> buckets;

        public MagicDictionary() {
            buckets = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            // computeIfAbsent() 方法对 hashMap 中指定 key 的值进行重新计算，如果不存在这个 key，则添加到 hashMap 中。
            //把字典的值放进去
            for (String dic : dictionary) {
                buckets.computeIfAbsent(dic.length(), x -> new ArrayList()).add(dic);
            }
        }

        public boolean search(String searchWord) {
            //字典里没有这个长度的直接返回
            if (!buckets.containsKey(searchWord.length())) {
                return false;
            }
            //遍历字典
            for (String can : buckets.get(searchWord.length())) {
                //用来计算字符差值
                int temp = 0;
                //遍历单词
                for (int i = 0; i < searchWord.length(); i++) {
                    if (searchWord.charAt(i) != can.charAt(i)) {
                        if (++temp > 1) {
                            break;
                        }
                    }
                }
                if (temp == 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
