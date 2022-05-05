package leetCode.双指针;


import java.util.Arrays;

public class leetCode_80_删除有序数组中的重复项II {
    public static void main(String[] args) {
        int []nums = {0, 0, 1, 1, 1, 1, 2, 3,3,3};
        System.out.println(removeDuplicates(nums));
    }
    private static int removeDuplicates(int [] nums){
        int n = nums.length;
        int slow=2;
        int fast=2;
        while(fast<n){
            if (nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
