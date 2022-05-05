package leetCode.leetCode_1000;

/**
 * 删除并获得点数
 */
public class leetCode_740_删除并获得点数 {
    public static void main(String[] args) {
        int[] nums = {0,2, 2, 3, 3, 3, 1};
        System.out.println(deleteAndEarn(nums));
    }

    private static int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sums = new int[maxVal + 1];
        for (int vals : nums
        ) {
            sums[vals] += vals;
        }
        return rob(sums);
    }

    private static int rob(int[] sums) {
        int first = sums[0];
        int second = Math.max(sums[0], sums[1]);
        for (int i = 2; i < sums.length; i++) {
            int temp = second;
            second = Math.max(first + sums[i], second);
            first = temp;
        }
        return second;
    }
}
