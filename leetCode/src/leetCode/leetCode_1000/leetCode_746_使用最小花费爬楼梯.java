package leetCode.leetCode_1000;

/**
 * 使用最小花费爬楼梯
 * */
public class leetCode_746_使用最小花费爬楼梯 {
    public static void main(String[] args) {
        int[]nums={1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(nums));

    }

    private static int minCostClimbingStairs(int[] nums) {
        int n=nums.length;
        int prev=0;int curr=0;
        for (int i = 2; i <= n; i++) {
            int text=Math.min(curr+nums[i-1],prev+nums[i-2]);
            prev=curr;
            curr=text;
        }
        return curr;
    }
}
