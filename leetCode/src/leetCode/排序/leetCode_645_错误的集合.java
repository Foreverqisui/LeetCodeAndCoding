package leetCode.排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetCode_645_错误的集合 {
    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(Arrays.toString(findErrorNums(nums)));
        System.out.println(Arrays.toString(findErrorNums1(nums)));
        System.out.println(Arrays.toString(findErrorNums2(nums)));
    }

    /**
     * 计数排序
     */
    private static int[] findErrorNums1(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 1];
        int[] count = new int[2];
        for (int num : nums
        ) {
            temp[num]++;
        }
        for (int i = 1; i <= n; i++) {
            if (temp[i] == 0) {
                count[1] = i;
            }
            if (temp[i] == 2) {
                count[0] = i;
            }
        }
        return count;
    }

    /**
     * 哈希表
     */
    private static int[] findErrorNums2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] temp = new int[2];
        for (int num : nums
        ) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i <= nums.length; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 0) {
                temp[1] = i;
            } else if (count == 2) {
                temp[0] = i;
            }
        }
        return temp;
    }


    /**
     * 排序
     */
    private static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] num = new int[2];
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (cur == pre) {
                num[0] = pre;
            } else if (cur - pre > 1) {
                num[1] = pre + 1;
            }
            pre = cur;
        }
        if (nums[n - 1] != n) {
            num[1] = n;
        }
        return num;
    }
}
