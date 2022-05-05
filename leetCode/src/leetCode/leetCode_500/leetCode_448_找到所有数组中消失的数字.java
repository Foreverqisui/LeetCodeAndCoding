package leetCode.leetCode_500;

import java.util.*;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * */
public class leetCode_448_找到所有数组中消失的数字 {
    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
    private static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
    /**
     * 优化写法
     * */
    private List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
