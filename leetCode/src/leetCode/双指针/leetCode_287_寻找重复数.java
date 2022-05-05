package leetCode.双指针;

import java.util.Arrays;

public class leetCode_287_寻找重复数 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate1(nums));
        System.out.println(findDuplicate2(nums));
    }

    private static int findDuplicate2(int[] nums) {
        int n=nums.length;

        int left=1;
        int right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            int cnt=0;
            for (int num:nums
                 ) {
                if (mid>=num){
                  cnt+=1;
                }
            }
            if (cnt>mid){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }


    /*快慢指针+环形链表*/
    private static int findDuplicate(int [] nums){
        int slow=0;
        int fast=0;
        slow=nums[slow];
        fast=nums[nums[fast]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        int pre=0;
        int pre1=slow;
        while(pre!=slow){
            pre=nums[pre];
            pre1=nums[pre1];
        }
        return pre;
    }

    /*垃圾的暴力解法，超出时限*/
    private static int findDuplicate1(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = n - 1;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = fast; j > i; j--) {
                if (nums[i] == nums[j]) {
                    return nums[i];

                }
            }
        }
        return nums[slow];
    }
}
