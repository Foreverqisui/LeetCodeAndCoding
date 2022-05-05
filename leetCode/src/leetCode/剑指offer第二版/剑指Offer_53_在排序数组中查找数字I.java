package leetCode.剑指offer第二版;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * */
public class 剑指Offer_53_在排序数组中查找数字I {
    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(search(nums, target));
    }
    private static int search(int[] nums, int target) {
        return searchER(nums,target)-searchER(nums,target-1);
    }
    public static int searchER(int[] nums,int target){
        int i = 0, j = nums.length-1;
        while(i<=j){
            int mid = (i+j)>>1;
            if(nums[mid]<=target){
                i = mid+1;
            }else{
                j = mid-1;
            }
        }
        return i;
    }
}
