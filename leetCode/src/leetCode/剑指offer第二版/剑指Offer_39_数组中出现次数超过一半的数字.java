package leetCode.剑指offer第二版;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * */
public class 剑指Offer_39_数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }
    private static int majorityElement(int[] nums) {
        Integer res = null;
        int count = 0;
        for(int num : nums) {
            if (count==0){
                res = num;
            }
            count+=res==num?1:-1;
        }
        return res;
    }
}
