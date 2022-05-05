package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * */

public class 剑指Offer_084_含有重复元素集合的全排列 {
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        Solution sol = new Solution();
        System.out.println(sol.permuteUnique(nums));
    }
    static class Solution {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean [] used;
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            used = new boolean[nums.length];
            backTrack(nums,0);
            return res;
        }

        private void backTrack(int[] nums, int start) {
            //递归终止条件
            if (nums.length==temp.size()){
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])){
                    continue;
                }
                temp.add(nums[i]);
                used[i] =true;
                backTrack(nums,start+1);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
