package leetCode.leetCode_2000;


/**
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
 *
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。如果选中的元素下标位置不一样，则认为两个子集 不同 。
 *
 * 对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 *
 * 示例 1：
 *
 * 输入：nums = [3,1]
 * 输出：2
 * 解释：子集按位或能得到的最大值是 3 。有 2 个子集按位或可以得到 3 ：
 * - [3]
 * - [3,1]
 * */
public class leetCode_2044_统计按位或能得到最大值的子集数目 {
    public static void main(String[] args) {

    }
    /**
     * dfs
     * 回溯
     * */
    class Solution {
        int[] nums;
        int max = 0, ans = 0;
        public int countMaxOrSubsets(int[] _nums) {
            nums = _nums;
            dfs(0, 0);
            return ans;
        }
        void dfs(int u, int val) {
            if (u == nums.length) {
                if (val > max) {
                    max = val; ans = 1;
                } else if (val == max) {
                    ans++;
                }
                return ;
            }
            dfs(u + 1, val);
            dfs(u + 1, val | nums[u]);
        }
    }
}
