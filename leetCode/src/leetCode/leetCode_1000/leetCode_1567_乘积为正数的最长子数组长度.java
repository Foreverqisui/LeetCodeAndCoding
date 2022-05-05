package leetCode.leetCode_1000;

public class leetCode_1567_乘积为正数的最长子数组长度 {
    public static void main(String[] args) {
        int []nums={-1,-2,-3,0,1};
        System.out.println(getMaxLen(nums));
    }

    private static int getMaxLen(int[] nums) {
        int l=nums.length;
        int p=nums[0]>0?1:0;
        int n=nums[0]<0?1:0;
        int max=p;
        for (int i = 1; i < l; i++) {
            if (nums[i]>0){
                p++;
                n=n>0?n+1:0;
            }else if (nums[i]<0){
                int newP=n>0?n+1:0;
                int newN=p+1;
                p=newP;
                n=newN;
            }else {
                p=0;
                n=0;
            }
            max=Math.max(max,p);
        }
        return max;
    }
}
