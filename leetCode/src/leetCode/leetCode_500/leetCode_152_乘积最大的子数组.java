package leetCode.leetCode_500;

/**
 * 乘积最大的子数组
 */
public class leetCode_152_乘积最大的子数组 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4};
        System.out.println(maxProduct(nums));
    }

    private static int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int imax=1;
        int imin=1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
                int temp=imax;
                imax =imin;
                imin=temp;
            }
            imax=Math.max(imax*nums[i],nums[i]);
            imin=Math.min(nums[i]*imin,nums[i]);
            max=Math.max(max,imax);
        }
        return max;
    }

}
