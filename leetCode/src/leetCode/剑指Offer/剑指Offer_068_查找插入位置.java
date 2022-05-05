package leetCode.剑指Offer;

/**
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 */
public class 剑指Offer_068_查找插入位置 {
    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,7));
    }
    /**
     * 二分
     * */
    private static int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid = (l+r)>>1;
            if (target>nums[mid]){
                l=mid+1;
            }else if(target<nums[mid]){
                r = mid-1;
            }else{
                return mid;
            }
        }
        return l;
    }
}
