package leetCode.剑指Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * */
public class 剑指Offer_100_三角形中最小路径之和 {
    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(0, Collections.singletonList(3));
        list.add(1, List.of(2, 3));
        list.add(2, List.of(5, 6, 7));
        System.out.println(minimumTotal(list));
    }
    private static int minimumTotal(List<List<Integer>> triangle) {
        //dp
        //三角形的底边逐层+1，所以taiangle的长度就是一行上所有的数字的数量
        int len = triangle.size();
        //构建dp矩阵，维护最小值
        int [] dp = new int [len+1];
        //显而易见，状态方程式 dp[i] = Math.min(dp[i],dp[i+1]) + 自身大小
        //反向计算路径和--从底向上
        for(int row = len-1;row>=0;row--){
            for(int col =0;col<=row;col++){
                dp[col] = Math.min(dp[col],dp[col+1])+triangle.get(row).get(col);
            }
        }
        return dp[0];
    }
}
