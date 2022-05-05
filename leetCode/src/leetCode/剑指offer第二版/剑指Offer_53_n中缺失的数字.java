package leetCode.剑指offer第二版;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 */
public class 剑指Offer_53_n中缺失的数字 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,6,7,8,9};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumberEr(nums));
    }

    /**
     * 二分
     */
    private static int missingNumberEr(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l+r)>>1;
            if (nums[mid]==mid){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }


    private static int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                res = i;
                break;
            }
        }
        return res;
    }
}
