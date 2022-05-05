package leetCode.leetCode_500;

public class leetCode_377_组合总和Ⅳ {
    public static void main(String[] args) {
        int [] nums={1,2,3};
        int target=4;
        System.out.println(combinationSum4(nums,target));
    }
    private static int combinationSum4(int[] nums, int target) {
        int [] dp=new int[target+1];
        dp[0]=1;
        for (int i = 1; i <= target; i++) {
            for (int c:nums
                 ) {
                if (c<=i){
                    dp[i]+=dp[i-c];
                }
            }
        }
        return dp[target];
    }
}
