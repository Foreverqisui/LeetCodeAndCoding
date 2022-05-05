package leetCode.排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetCode_594_最长和谐子序列 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(findLHS(nums));
    }
    /**
     * 排序+快慢指针
     **/
    private static int findLHS(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        Arrays.sort(nums);
        int res = 0;
        //将一样的数归进来
        for (; right < n; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }
            //做了个最大值的维护
            if (nums[right] - nums[left] == 1) {
                res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }
    /**
     * 哈希表
     * */
    public int findLHS1(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (long num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (long key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                result = Math.max(result, map.get(key + 1) + map.get(key));
            }
        }
        return result;
    }
}
