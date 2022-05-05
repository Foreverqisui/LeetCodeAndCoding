package leetCode.排序;

import java.util.Arrays;

public class leetCode_922_按奇偶排序数组II {
    public static void main(String[] args) {
        int [] nums ={4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
        System.out.println(Arrays.toString(sortArrayByParityII1(nums)));
    }

    /**
     * 双指针
     * */
    private static int[] sortArrayByParityII1(int[] nums) {
        int n = nums.length;
        int right = 1;
        for (int left = 0; left < n; left+=2) {
            if (nums[left] %2==1){
                while (nums[right] %2==1){
                    right+=2;
                }
                swap(nums,left,right);
            }
        }
        return nums;
    }
    private static void swap(int []nums,int left,int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right]=temp;

    }

    /**
     * 两次遍历
     * */
    private static int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int [] ans= new int[n];
        int i = 0;
        for(int num:nums){
            if (num%2==0){
                ans[i] = num;
                i+=2;
            }
        }
        int j =1;
        for(int num:nums){
            if (num%2==1){
                ans[j] = num;
                j+=2;
            }
        }
        return ans;
    }
}
