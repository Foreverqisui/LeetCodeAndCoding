package leetCode.剑指Offer;

import java.util.*;

/**
 * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 需要输出替换之后的句子。
 *
 *
 *
 * 示例 1：
 *
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * */
public class 剑指Offer_063_替换单词 {
    public static void main(String[] args) {
        String[] str = {"cat","bat","rat"};
        List<String> dictionary = new ArrayList<String>(Arrays.asList(str));
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary,sentence));
    }
    /**
     * 实现一颗字典前缀树
     * */
    class Solution {
        public String replaceWords(List<String> roots, String sentence) {
            TrieNode trie = new TrieNode();
            for (String root: roots) {
                TrieNode cur = trie;
                for (char letter: root.toCharArray()) {
                    if (cur.children[letter - 'a'] == null) {
                        cur.children[letter - 'a'] = new TrieNode();
                    }
                    cur = cur.children[letter - 'a'];
                }
                cur.word = root;
            }

            StringBuilder ans = new StringBuilder();

            for (String word: sentence.split("\\s+")) {
                if (ans.length() > 0) {
                    ans.append(" ");
                }

                TrieNode cur = trie;
                for (char letter: word.toCharArray()) {
                    if (cur.children[letter - 'a'] == null || cur.word != null) {
                        break;
                    }
                    cur = cur.children[letter - 'a'];
                }
                ans.append(cur.word != null ? cur.word : word);
            }
            return ans.toString();
        }
    }

    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
        }
    }


    /**
     * 暴力哈希
     * 通过集合存储词根，通过比较词根是否存在，来判断进行结果的替换
     * */
    private static String replaceWords(List<String> dictionary, String sentence) {
        //将所有的词根放入集合中
        Set<String> set = new HashSet<>(dictionary);
        //结果变量
        StringBuilder res = new StringBuilder();
        //遍历字符串，以\\s+来进行分割匹配
        // \\s ==\s 表示转义字符 ,\s表示匹配任意空格（包括空格，制表符，换页符）
        // \\s+中的'+'表示多次匹配
        for(String word:sentence.split("\\s+")){
            //前缀变量，用来存储前缀值，找到符合要求的前缀
            String prefix = "";
            //遍历单个字符，找到前缀
            //注：字符串要包含末尾
            for(int i =1;i<=word.length();i++){
                //为前缀赋值，找到对应的位置
                prefix = word.substring(0,i);
                //判断是否包含
                if(set.contains(prefix)){
                    break;
                }
            }
            //结果拼接
            //判断是否是第一个字符 如果不是，需要在末尾拼接空格
            if(res.length()>0){
                res.append(" ");
            }
            res.append(prefix);
        }
        return res.toString();
    }
}
