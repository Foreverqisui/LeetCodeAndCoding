package leetCode.剑指Offer;

import java.util.Arrays;

/**
 * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
 * <p>
 * words.length == indices.length
 * 助记字符串 s 以 '#' 字符结尾
 * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 * <p>
 * 给定一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
 * <p>
 * 输入：words = ["time", "me", "bell"]
 * 输出：10
 * 解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
 * words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 */
public class 剑指Offer_065_最短的单词编码 {
    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};

    }

    class Solution {
        public int minimumLengthEncoding(String[] words) {
            //返回的结果长度
            int res = 0;
            //初始化字典树
            Trie trie = new Trie();
            // 先对单词列表根据单词长度由长到短排序
            Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
            //遍历字符数组，倒序插入字典树中
            //不存在已有前缀则加1 不是则返回0
            for(String word:words){
                res+=trie.insert(word);
            }
            return res;
        }}

    //构建一棵字典树
    class Trie{
        //节点
        TrieNode root;
        //借助构造器，节点初始化
        public Trie(){
            root = new TrieNode();
        }

        //倒序插入的方法
        public int insert(String word){
            //判断是否存在前缀
            boolean isNew = false;
            //获得根节点位置
            TrieNode cur = root;
            for(int i =word.length()-1;i>=0;i--){
                //获得单词对应编码
                int c = word.charAt(i)-'a';
                //判断是否存在对应前缀
                if(cur.children[c] == null){
                    //是新单词
                    isNew = true;
                    //将此值插入字典树
                    cur.children[c] = new TrieNode();
                }
                //移动去子节点
                cur = cur.children[c];
            }
            // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
            return isNew? word.length() + 1: 0;
        }
    }
    //构建字典树节点
    class TrieNode{
        //节点值
        char val;
        //26个字母的子节点数组
        TrieNode[] children = new TrieNode[26];
        public TrieNode(){};
    }
}

