package leetCode.双指针;

import java.util.Arrays;



/**
 * 移动零
 */
public class leetCode_283_移动零 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        System.out.println(Arrays.toString(moveZeroes(nums)));
        System.out.println(Arrays.toString(moveZeroes1(nums)));
    }


    /**
     * swap交换
     * */
    private static int[] moveZeroes1(int[] nums) {
        int n = nums.length;
        int fast = 0;
        for (int i = 0; i < n; i++) {
          if (nums[i]!=0){
              int temp = nums[i];
              nums[i] = nums[fast];
              nums[fast] = temp;
              fast++;
          }
        }
            return nums;
    }


    //普通双指针
    private static int[] moveZeroes(int[] nums) {
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int num = nums[i];
                nums[i] = nums[right];
                nums[right++] = num;
            }
        }
        return nums;
    }
}
