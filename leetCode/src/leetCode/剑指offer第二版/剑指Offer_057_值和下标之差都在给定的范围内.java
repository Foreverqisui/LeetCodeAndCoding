package leetCode.剑指offer第二版;

import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
 * 使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 */
public class 剑指Offer_057_值和下标之差都在给定的范围内 {
    public static void main(String[] args) {
        int[] nums = {1, 5,9,1,5,9};
        int k = 2, t = 3;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long)nums[i] );
            if (i>=k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;

    }
}
