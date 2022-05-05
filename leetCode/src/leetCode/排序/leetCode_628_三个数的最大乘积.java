package leetCode.排序;

import java.util.Arrays;

public class leetCode_628_三个数的最大乘积 {
    public static void main(String[] args) {
        int [] nums = {-1,-2,4,1,3};
        System.out.println(maximumProduct(nums));
        System.out.println(maximumProduct1(nums));
    }

    /**
     * 线性扫描
     * */
    private static int maximumProduct1(int[] nums) {
        int n = nums.length;
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE,min1 = Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        for (int num:nums
             ) {
            if (num>max1){
                max3=max2;
                max2=max1;
                max1=num;
            }else if(num>max2){
                max3=max2;
                max2=num;
            }else if(num>max3){
                max3=num;
            }
            if (num<min1){
                min2=min1;
                min1=num;
            }else if(num<min2){
                min2=num;
            }
        }
        return Math.max((max1*max2*max3),(min1*min2*max1));
    }

    /**
     * 排序
     * */
    private static int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max((nums[0]*nums[1]*nums[n-1]),(nums[n-3]*nums[n-2]*nums[n-1]));
    }
}
