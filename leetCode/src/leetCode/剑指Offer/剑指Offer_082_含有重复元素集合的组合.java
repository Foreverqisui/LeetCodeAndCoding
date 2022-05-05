package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class 剑指Offer_082_含有重复元素集合的组合 {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution sol = new Solution();
        System.out.println(sol.combinationSum2(candidates, target));
    }

    static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            //有序之后才能进行剪枝操作
            Arrays.sort(candidates);
            backTrack(candidates, target, 0);
            return res;
        }

        private void backTrack(int[] candidates, int target, int start) {
            //递归终止条件
            if (target == 0) {
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                //大剪枝 -- 减去后面的无谓计算
                if (target-candidates[i]<0){
                    break;
                }
                //小剪枝 -- 当有重复元素时，会产生相同的结果
                if (i>start && candidates[i]==candidates[i-1]){
                    continue;
                }
                temp.add(candidates[i]);
                backTrack(candidates, target - candidates[i], i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
