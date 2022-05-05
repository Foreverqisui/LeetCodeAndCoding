package leetCode.剑指Offer;

import java.lang.reflect.Array;
import java.util.*;

public class 剑指Offer_004_只出现一次的数字 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 3};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber1(nums));
    }

    /**
     * 万恶的位运算
     * 依次确定每一个二进制位
     * 时间复杂度 ：O(nlog⁡C)
     */
    private static int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 哈希表
     * 遍历每一个元素
     * 时间复杂度：O(n)
     */
    private static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        // Map.Entry Returns the key corresponding to this entry.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (value == 1) {
                res = key;
                break;
            }
        }
        return res;
    }
}

