package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class 剑指Offer_080_含有k个元素的组合 {
    public static void main(String[] args) {
        int n = 4, k = 2;
        Solution sol = new Solution();
        System.out.println(sol.combine(n, k));
    }

    static class Solution {
        //这个东西放在外面 是防止每次初始化 操作
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            //题目分析-- 首先可以发现这是道排列的题 -- 排列的题做 -- 回溯
            //再分析一下 这和别的排列有什么区别
            // 1.-- 限制了每个数组中的额定长度--k
            // 2.-- 数目是在n中拿
            // 也就是说 这个题的排列是要遍历n元素 依次找到符合k长度的组合情况

            //第一步 调用函数 直接回溯

            backTrack(n, k, 1);
            return res;
        }

        private void backTrack(int n, int len, int start) {
            //回溯 -- 递归的一种 既然是递归 就要有终止条件 --单个数组的长度 等于len时 满足了要求 添加到结果里
            //剪枝-- 因为发现到后面 总长度 都没有要求的长度大 所以就剪去了
            if (temp.size() + n - start + 1 < len) {
                return;
            }
            //递归终止条件
            if (temp.size() == len) {
                res.add(new ArrayList<>(temp));
                return;
            }
            temp.add(start);
            //回溯下一个
            backTrack(n, len, start + 1);
            //删掉这个 换下一个
            temp.remove(temp.size() - 1);
            //接着往下找
            backTrack(n, len, start + 1);

        }
    }
}
