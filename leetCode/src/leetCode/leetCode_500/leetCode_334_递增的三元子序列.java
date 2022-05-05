package leetCode.leetCode_500;

public class leetCode_334_递增的三元子序列 {
    public static void main(String[] args) {
        int [] nums = {2,1,5,7,4};
        System.out.println(increasingTriplet(nums));
        System.out.println(increasingTriplet1(nums));
    }

    private static boolean increasingTriplet1(int[] nums) {
        int n = nums.length;
        if (n<3){
            return false;
        }
        int small = nums[0];
        int mid = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int big = nums[i];
            if (big>mid) {
                return true;
            }else if (big>small) {
                mid = big;
            }else {
                small = big;
            }
        }
        return false;
    }


    private static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE,big = Integer.MAX_VALUE;
        for (int n :nums
             ) {
            if (n<=small) {
                small = n;
            }else if(n<=big) {
                big = n;
            }else{
                return true;
            }
        }
        return false;
    }
}
