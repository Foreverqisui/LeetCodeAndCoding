package leetCode.排序;

import java.util.*;

public class LeetCode_268_丢失的数字 {
    public static void main(String[] args) {
        int [] nums = {0,1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber1(nums));
    }


    /**
     * 哈希表
     * */
    private static int missingNumber1(int[] nums) {
        Set<Integer> map = new HashSet<Integer>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.add(nums[i]);
        }
        int missing = -1;
        for (int i = 0; i <= n; i++) {
            if (!map.contains(i)) {
                missing =i;
                break;
            }
        }
        return missing;

    }


    /**
     * 调用API排序
     * */
    private static int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i]!=i){
                return i;
            }
        }
        return n;
    }
}
