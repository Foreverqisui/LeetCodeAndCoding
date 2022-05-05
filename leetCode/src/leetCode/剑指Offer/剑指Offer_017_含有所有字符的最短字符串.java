package leetCode.剑指Offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 * <p>
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 * <p>
 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
 */
public class 剑指Offer_017_含有所有字符的最短字符串 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        Solution sol = new Solution();
        String res = sol.minWindow(s, t);
        System.out.println(res);
    }

    /**
     * 思路：词频数组用来统计出现的次数
     * 滑动窗口用来找到最小子串
     */
    static class Solution {
        //这是统计t字符频数的哈希表
        Map<Character, Integer> ori = new HashMap<>();
        //这是统计s字符频数的哈希表
        Map<Character, Integer> cnt = new HashMap<>();

        private String minWindow(String s, String t) {
            //初始化 --左右窗口 计数的词频数组--用哈希表
            int tLen = t.length(), l = 0, r = -1, len = Integer.MAX_VALUE,
                    ansL = -1, ansR = -1, sLen = s.length();
            ;
            //把t的字符放入词频数组中
            for (int i = 0; i < tLen; i++) {
                char c = t.charAt(i);
                ori.put(c, ori.getOrDefault(c, 0) + 1);
            }
            //右窗口移动--找到满足的子串
            while (r < sLen) {
                r++;
                //对s字符中满足要求的字符进行统计
                if (r < sLen && ori.containsKey(s.charAt(r))) {
                    cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
                }
                //判断是否满足长度，并且统计当前字符长度
                while (check() && l <= r) {
                    if (r - l + 1 < len) {
                        //统计字符长度
                        len = r - l + 1;
                        //左右窗口值
                        ansL = l;
                        ansR = l + len;
                    }
                    //左窗口移动--找到最小满足子串
                    if (ori.containsKey(s.charAt(l))) {
                        cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                    }
                    ++l;
                }
            }
            return ansL == -1 ? "" : s.substring(ansL, ansR);
        }
        //利用迭代器，检查ori里面的每一项，之后和cnt进行比较，检查cnt的词频是否大于等于ori
        private boolean check() {
            Iterator iter = ori.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Character key = (Character) entry.getKey();
                Integer val = (Integer) entry.getValue();
                //判断当前cnt词频数组每一项是否大于ori的
                if (cnt.getOrDefault(key, 0) < val) {
                    return false;
                }
            }
            return true;
        }
    }
}
