package leetCode.剑指Offer;

import java.util.Arrays;

public class 剑指Offer_012_左右两边子数组的和相等 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

    private static int pivotIndex(int[] nums) {
        //求数组流元素中的总和
        int total = Arrays.stream(nums).sum();
        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            if (2*sum==total-nums[i]){
                return i;
            }
            sum+=nums[i];
        }
        return -1;
    }
}
