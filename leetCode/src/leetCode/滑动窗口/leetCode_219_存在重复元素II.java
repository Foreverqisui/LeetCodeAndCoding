package leetCode.滑动窗口;

import java.util.HashSet;
import java.util.Set;

public class leetCode_219_存在重复元素II {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums,k));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<Integer>();
            for(int i = 0; i < nums.length; i++) {
                if(set.add(nums[i])) {
                    if(set.size() > k) {
                        set.remove(nums[i - k]);
                    }
                } else {
                    return true;
                }
            }
            return false;
    }

}
