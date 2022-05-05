package leetCode.leetCode_500;

/**
 * 等差数列划分
 */
public class leetCode_413_等差数列划分 {
    public static void main(String[] args) {
        int[] nums = {0, -1, -2, -3};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    private static int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if (n==1) return 0;
        int sum=nums[0]-nums[1];
        int t=0;int ans=0;
        for (int i = 2; i < n; i++) {
            if (nums[i-1]-nums[i]==sum){
                ++t;
            }else {
                t=0;
                sum=nums[i-1]-nums[i];
            }
            ans+=t;
        }
        return ans;

    }
}
