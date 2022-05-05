package leetCode.排序;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetCode_720_词典中最长的单词 {
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(words));
    }


    private static String longestWord(String[] words) {
        Arrays.sort(words);
        //创建一个哈希表，用来存储元素
        Set<String> set = new HashSet<String>();
        String s = "";
        for (String word : words) {
            //用哈希表进行维护，如果存在前缀，并且长度大于s的，则把他加入到哈希表内
            if (word.length()==1||set.contains(word.substring(0,word.length()-1))){
                s = word.length()>s.length()?word:s;
                set.add(word);
            }
        }
        return s;
    }
}
