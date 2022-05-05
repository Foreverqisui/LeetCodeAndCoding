package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * */
public class 剑指Offer_083_没有重复元素集合的全排列 {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(permute(nums));
        Solution solution = new Solution();
        System.out.println(solution.permute(nums));
    }
    static class Solution{
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            backTrack(nums);
            return res;
        }
        public void backTrack(int[] nums){
            //递归终止条件
            if (temp.size()==nums.length){
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                //剪枝
                if (temp.contains(nums[i])){
                    continue;
                }
                temp.add(nums[i]);
                backTrack(nums);
                temp.remove(temp.size()-1);
            }
        }
    }




    public static List<List<Integer>> permute(int[] nums) {
        //回溯 -- 首先要构建结果集
        List<List<Integer>> res = new ArrayList<>();
        //接着呢将数组里的值那出来
        List<Integer> temp = new ArrayList<>();
        for(int num:nums){
            temp.add(num);
        }
        //进行回溯
        int len = nums.length;
        backTrack(len,res,temp,0);
        return res;
    }

    private static void backTrack(int len, List<List<Integer>> res, List<Integer> temp, int first) {
        //递归终止条件
        if (len==first) {
            res.add(new ArrayList<>(temp));
        }
        //全排列
        for (int i = first; i < len; i++) {
            //交换数组位置
            Collections.swap(temp,first,i);
            //回溯操作 递归下一个数
            backTrack(len,res,temp,first+1);
            //撤销
            Collections.swap(temp,first,i);
        }
    }
}
