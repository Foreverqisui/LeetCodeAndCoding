package leetCode.排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetCode_747_至少是其他数字两倍的最大数 {
    public static void main(String[] args) {
        int[] nums = {3,6,1,0};
        System.out.println(dominantIndex(nums));
        System.out.println(dominantIndex1(nums));
    }

    /**
     * 哈希表(自己完整做对的第一题)
     */
    private static int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        if (nums[nums.length - 1] >= 2 * nums[nums.length - 2]) {
            return map.get(nums[nums.length - 1]);
        }
        return -1;
    }


    /**
     * 线性扫描
     * */
    private static int dominantIndex1(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i]>nums[max]) {
                max = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (max!=i && nums[max]<2*nums[i]) {
                return -1;
            }
        }
        return max;
    }

}
