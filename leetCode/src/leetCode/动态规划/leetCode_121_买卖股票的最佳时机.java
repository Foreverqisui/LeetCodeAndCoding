package leetCode.动态规划;

public class leetCode_121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        int [] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
        System.out.println(maxProfit1(nums));
    }

    private static int maxProfit1(int[] nums) {
        int maxCur = 0;
        int maxSoFar = 0;
        for (int i = 1; i < nums.length; i++) {
            maxCur = Math.max(0,maxCur + nums[i]-nums[i-1]);
            maxSoFar = Math.max(maxSoFar,maxCur);
        }
        return maxSoFar;
    }


    private static int maxProfit(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i]<min){
                min = nums[i];
            }else if (nums[i]-min>max){
                max = nums[i]-min;
            }
        }
        return max;
    }
}
