package leetCode.剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class 剑指Offer_005_单词长度的最大乘积 {
    public static void main(String[] args) {
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        System.out.println(maxProduct(words));
    }
    /**
     位运算 + 预计算
     时间复杂度：O((m + n)* n)
     */
    public int maxProduct2(String[] words) {
        // O(mn)
        Map<Integer, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int bitMask = 0;
            for (char c : words[i].toCharArray()) {
                bitMask |= (1 << (c - 'a'));
            }
            // there could be different words with the same bitmask
            // ex. ab and aabb
            map.put(bitMask, Math.max(map.getOrDefault(bitMask, 0), words[i].length()));
        }

        // O(n^2)
        int ans = 0;
        for (int x : map.keySet()) {
            for (int y : map.keySet()) {
                if ((x & y) == 0) {
                    ans = Math.max(ans, map.get(x) * map.get(y));
                }
            }
        }
        return ans;
    }


    /**
     * 暴力法
     * 时间复杂度 O（n2）
     */
    private static int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String word1 = words[j];
                if (!hasSame1(word, word1)) {
                    max = Math.max(max, word.length() * word1.length());
                }
            }
        }
        return max;
    }

    private static boolean hasSame(String word, String word1) {
        for (char c : word1.toCharArray()) {
            if (word.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 计数优化
     */
    private static boolean hasSame1(String word1, String word2) {
        int[] count = new int[26];
        for (char c : word1.toCharArray()) {
            count[c-'a']=1;
        }
        for (char c : word2.toCharArray()) {
            if (count[c-'a']==1){
                return true;
        }
        }
        return false;
    }
}
