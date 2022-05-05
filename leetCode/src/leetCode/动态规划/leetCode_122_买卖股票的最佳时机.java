package leetCode.动态规划;

/**
 * 买卖股票的最佳时机
 * */
public class leetCode_122_买卖股票的最佳时机 {
    public static void main(String[] args) {
        int []nums={7,1,3,9,4,5};
        System.out.println(maxProfix(nums));
    }

    private static int maxProfix(int[] nums) {
        int sum=0;
        int length=nums.length;
        for (int i = 1; i < length; i++) {
            sum+=Math.max(0,nums[i]-nums[i-1]);
        }
        return sum;
    }
}
