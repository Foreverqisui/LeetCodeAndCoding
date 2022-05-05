package leetCode.二分查找;

import java.util.Arrays;

/**
 * @author foreverqisui
 */



//二分查找，通过判断第一个出现的target的位置和判断第一个出现target+1的位置，来求出target起始位置和结束位置

public class leetCode_34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] data = {5, 7, 7, 8, 8, 10};
        int target = 7;
        System.out.println(Arrays.toString(searchRange(data, target)));
    }

    private static int[] searchRange(int[] nums, int target) {
        //l是target的第一个
        int l =search(nums, target);
        // r是大于target的第一个
        int r= search(nums, target+1);
        if (l==nums.length||nums[l]!=target){
            return new int[]{-1,-1};
        }

        return new int[]{l,r-1};


    }
    private static int search(int [] nums,int target){
        int n = nums.length;
        int left = 0;
        int right =n;
        while(left < right){
            int mid = (right + left)>>1;
            if (nums[mid] >= target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
