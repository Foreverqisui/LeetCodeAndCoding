package leetCode.剑指offer第二版;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * <p>
 */
public class 剑指Offer_56I_数组中数字出现的次数 {
    public static void main(String[] args) {
        int[] nums = {4,1,4,6};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }

    private static int[] singleNumbers(int[] nums) {
        int ret = 0;
        //获取相同数字的异或和
        for (int n : nums) {
            ret ^= n;
        }
        //寻找不相同的位数
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        //分组异或求单次出现
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
