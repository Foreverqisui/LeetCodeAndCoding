package leetCode.双指针;

import java.util.Arrays;

public class leetCode_75_颜色分类 {
    public static void main(String[] args) {
       int[] nums = {2,0,2,1,1,0};
       sortColours(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void sortColours(int[] nums) {
        int n=nums.length;
        if (n<2) return;
        int p0=0;
        int p1=n;
        int i=0;
        while(i<p1){
            if (nums[i]==0){
                swap(nums,i,p0);
                p0++;
                i++;
            }else if (nums[i]==1){
                i++;
            }else {
                p1--;
                swap(nums,i,p1);
            }
        }

    }

    private static void swap(int[] nums, int slow, int fast) {
            int temp=nums[fast];
            nums[fast]=nums[slow];
            nums[slow]=temp;

    }
}
