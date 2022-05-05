package leetCode.剑指Offer;

import java.util.*;

/**
 * 给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。
 * <p>
 * 输入：s = "google"
 * 输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
 */
public class 剑指Offer_086_分割回文子字符串 {

    public static void main(String[] args) {
        String s = "abbc";
        Solution solution = new Solution();
        System.out.println(solution.partition(s));
    }

    static class Solution {
        List<String> temp = new ArrayList<String>();
        List<List<String>> res = new ArrayList<List<String>>();
        Deque<String> stack = new LinkedList<>();
        public List<List<String>> partition(String s) {
            int len = s.length();
            if (len ==0){
                return res;
            }
            char[] ch = s.toCharArray();
            dfs(ch,0,len);
            return res;
        }

        private void dfs(char[] array, int left, int right) {
            //递归终止
            if (left == right){
                res.add(new ArrayList<>(stack));
                return;
            }
            //遍历
            for (int i = left; i < right; i++) {
                //判断是否回文
                if (checkCh(array,left,i)){
                    stack.offerLast(new String(array,left,i+1-left));
                    dfs(array,i+1,right);
                    stack.removeLast();
                }
            }
        }

        private boolean checkCh(char[] array, int left, int right) {
            while (left < right){
                if (array[left] !=array[right]){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
