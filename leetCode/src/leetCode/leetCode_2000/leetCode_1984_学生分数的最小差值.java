package leetCode.leetCode_2000;

import java.util.Arrays;

public class leetCode_1984_学生分数的最小差值 {
    public static void main(String[] args) {
        int [] nums = {9,4,1,7};
        int k =2;
        System.out.println(minimumDifference(nums, k));
    }

    /**
     * 输入：nums = [9,4,1,7], k = 2
     * 输出：2
     * 解释：选出 2 名学生的分数，有 6 种方法：
     * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 4 = 5
     * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 1 = 8
     * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 7 = 2
     * - [9,4,1,7] 最高分和最低分之间的差值是 4 - 1 = 3
     * - [9,4,1,7] 最高分和最低分之间的差值是 7 - 4 = 3
     * - [9,4,1,7] 最高分和最低分之间的差值是 7 - 1 = 6
     * 可能的最小差值是 2
     * */
    private static int minimumDifference(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i+k-1<nums.length;i++){
            res = Math.min(res,nums[i+k-1]-nums[i]);
        }
        return res;
    }
}
