package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，
 * 找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * */
public class 剑指Offer_081_允许重复选择元素的组合 {

    public static void main(String[] args) {
        int [] candidates = {2,3,6,7};
        int target = 7;
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(candidates,target));
    }
    static class Solution{
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        private List<List<Integer>> combinationSum(int[] candidates, int target) {
            //老样子，看到这道题，仔细想想又是排列的题 --回溯
            //再看看问题点 -- 根据已有数组找到目标和 -- 没有长度限制 但是重复选取就很呆
            //那怎么解决呢？ -- 先按正常的回溯写一下

            //排序的目的是为了剪枝做条件 当在前面的值已经超过目标值的时候，再找后面的值同理会超过
            Arrays.sort(candidates);
            backTrack(candidates, target,0);
            return res;
        }

        private void backTrack(int[] candidates, int target, int index) {
            //老生常谈 递归第一步 -- 边界条件
            if (index==candidates.length){
                return;
            }
            //满足条件的值
            if (target==0){
                res.add(new ArrayList<>(temp));
                return;
            }
            //
            for (int i = index; i < candidates.length; i++) {
                //剪枝
                if (target-candidates[i]<0){
                    break;
                }
                temp.add(candidates[i]);
                backTrack(candidates, target-candidates[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
