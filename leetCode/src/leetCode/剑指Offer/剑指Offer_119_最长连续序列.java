package leetCode.剑指Offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * */
public class 剑指Offer_119_最长连续序列 {
    public static void main(String[] args) {
        int [] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(nums));
    }
    private static int longestConsecutive(int[] nums) {
        //set去重且排序
        Set<Integer> set = new HashSet<Integer>();
        //遍历放入数组
        for (int value : nums) {
            set.add(value);
        }
        //记录结果
        int res = 0;
        //遍历集合
        for(int num : set){
            //找最小的开头
            if (!set.contains(num-1)){
                //此时就是最小的开头了
                //记录开头
                int curNum = num;
                int temp = 1;
                //判断比他有序大的有几个
                while(set.contains(curNum+1)){
                    //转换开头
                     curNum++;
                    temp++;
                }
                //记录最大结果
                res = Math.max(temp,res);
            }
        }
        return res;
    }
}
