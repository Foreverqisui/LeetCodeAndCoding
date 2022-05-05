package leetCode.排序;

import java.util.Arrays;

public class leetCode_561_数组拆分I {
    public static void main(String[] args) {
        int [] nums= {6,2,6,5,1,3};
        System.out.println(arrayPairSum(nums));
    }
    private static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i+=2) {
            max += nums[i];
        }
        return max;
    }

}
