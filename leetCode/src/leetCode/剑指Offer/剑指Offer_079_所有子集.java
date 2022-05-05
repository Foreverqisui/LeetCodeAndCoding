package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * */
public class 剑指Offer_079_所有子集 {

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        //排列问题：回溯yyds
        //构建结果集
        List<List<Integer>> res = new ArrayList<>();
        //构建中间存储变量
        List<Integer> temp = new ArrayList<>();
        //回溯调用
        backTrack(res,temp,0,nums);
        return res;
    }
    public static void backTrack(List<List<Integer>> res,List<Integer> temp,int start,int [] nums){
        //结果集
        res.add(new ArrayList<>(temp));
        //遍历 逐渐向下移动
        for(int i=start;i<nums.length;i++){
            //对中间变量赋值
            temp.add(nums[i]);
            //已父元素为根节点 对下一个元素进行遍历
            backTrack(res,temp,i+1,nums);
            //删掉前一个元素 -- 撤出此次dfs 直到删掉父节点
            //开始换下一个元素作为父节点进行dfs
            temp.remove(temp.size()-1);
        }
    }
}
