package leetCode.leetCode_2000;

import java.util.HashMap;
import java.util.Map;

public class leetCode_2006_差的绝对值为K的数对数目 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4};
        int k = 2;
        System.out.println(countKDifference(nums, k));
        System.out.println(countKDifference1(nums, k));
    }


    private static int countKDifference1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += map.getOrDefault(nums[i] - k, 0)
                    + map.getOrDefault(nums[i] + k, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }


    private static int countKDifference(int[] nums, int k) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
