package leetCode.leetCode_500;

public class leetCode_309_最佳买卖股票时机含冷冻期 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(nums));
    }

    private static int maxProfit(int[] nums) {
            if (nums.length==0) return 0;
            int n=nums.length;
            int f0=-nums[0];
            int f1=0;
            int f2=0;
        // f0: 手上持有股票的最大收益
        // f1: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f2: 手上不持有股票，并且不在冷冻期中的累计最大收益
        for (int i = 1; i < n; i++) {
            int newF0=Math.max(f0,f2-nums[i]);
            int newF1=f0+nums[i];
            int newF2=Math.max(f1,f2);
            f0=newF0;
            f1=newF1;
            f2=newF2;
        }
        return Math.max(f1,f2);
    }
}
