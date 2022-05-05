package leetCode.剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 *     MapSum() 初始化 MapSum 对象
 *     void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 *     int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 * 示例：
 *
 * 输入：
 * inputs = ["MapSum", "insert", "sum", "insert", "sum"]
 * inputs = [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 * */

public class 剑指Offer_066_单词之和 {

    class MapSum {

        class TrieNode{
            int val = 0;
            TrieNode [] children = new TrieNode[26];
        }

        //结构初始化
        TrieNode root;
        Map<String,Integer> map;

        public MapSum() {
            root = new TrieNode();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            //存储和
            int detal = val - map.getOrDefault(key,0);
            //更换键值对进行值改变 或 插入新的键值对进行值存储
            map.put(key,val);
            //插入字典树
            //1.构建辅助指针
            TrieNode cur = root;
            //2.遍历插入
            for(char c : key.toCharArray()){
                //3.寻找子节点是否为空
                if(cur.children[c-'a']==null){
                    //4.为空则创建新节点
                    cur.children[c-'a'] = new TrieNode();
                }
                //5.寻找下面的子节点
                cur = cur.children[c-'a'];
                //存值为和
                cur.val += detal;
            }
        }

        public int sum(String prefix) {
            TrieNode cur = root;
            for(char c :prefix.toCharArray()){
                if(cur.children[c-'a']==null){
                    return 0;
                }
                cur = cur.children[c-'a'];
            }
            return cur.val;
        }
    }
}
