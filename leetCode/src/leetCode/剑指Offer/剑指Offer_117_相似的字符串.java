package leetCode.剑指Offer;

/**
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。
 * 如果这两个字符串本身是相等的，那它们也是相似的。
 *
 * 给定一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个 字母异位词 。
 * 请问 strs 中有多少个相似字符串组？
 *
 * 字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。
 * 示例 1：
 *
 * 输入：strs = ["tars","rats","arts","star"]
 * 输出：2
 * */
public class 剑指Offer_117_相似的字符串 {
    public static void main(String[] args) {
        String [] strs = {"tars","rats","arts","star"};
        Solution sol = new Solution();
        System.out.println(sol.numSimilarGroups(strs));
    }
    static class Solution {
        int[] f;

        public int numSimilarGroups(String[] strs) {
            //初始化
            int n = strs.length;
            int m = strs[0].length();
            f = new int[n];

            for (int i = 0; i < n; i++) {
                f[i] = i;
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {

                    int fi = find(i), fj = find(j);

                    if (fi == fj) {
                        continue;
                    }

                    if (check(strs[i], strs[j], m)) {
                        //合并两个集合
                        f[fi] = fj;
                    }
                }
            }
            //结果
            int ret = 0;
            for (int i = 0; i < n; i++) {
                if (f[i] == i) {
                    ret++;
                }
            }
            return ret;
        }
        //寻找父节点
        public int find(int x) {
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        //检查两个字符串是否在两个字符的差距以内
        public boolean check(String a, String b, int len) {
            int num = 0;
            for (int i = 0; i < len; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    num++;
                    if (num > 2) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
