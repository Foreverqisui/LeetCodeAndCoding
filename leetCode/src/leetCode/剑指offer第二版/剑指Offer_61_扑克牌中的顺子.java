package leetCode.剑指offer第二版;

import java.util.HashSet;
import java.util.Set;

/**
 *从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * */
public class 剑指Offer_61_扑克牌中的顺子 {

    public static void main(String[] args) {
        int [] nums = {0,0,2,3,5};
        System.out.println(isStraight(nums));
    }
    private static boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int min = 0,max = 0;
        for (int i = 0; i < nums.length; i++) {
            //遇到0则跳过
            if (nums[i]==0){
                continue;
            }
            //获得最大和最小值
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
            //遇到重复的直接返回false
            if (set.contains(nums[i])){
                return false;
            }
            //其他情况放入
            set.add(nums[i]);
        }
        return max-min<5;
    }
}
