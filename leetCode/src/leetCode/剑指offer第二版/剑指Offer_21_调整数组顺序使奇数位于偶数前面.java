package leetCode.剑指offer第二版;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * */
public class 剑指Offer_21_调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        System.out.println(Arrays.toString(exchange(nums)));
        System.out.println(Arrays.toString(exchange1(nums)));
    }
    /**
     * 双指针
     * */
    private static int [] exchange1(int[] nums) {
        int n = nums.length;
        int l = 0,r=n-1;
        while(l<r){
            while(l<r&&(nums[l]&1)==1){
                l++;
            }
            while(l<r&&(nums[l]&1)==0){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
            }
        }
        return nums;
    }


    /**
     * 借助双端队列
     * */
    private static int[] exchange(int[] nums) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int [] res=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2==0){
                queue.offerLast(nums[i]);
            }else {
                queue.offerFirst(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = queue.pop();
        }
        return res;

    }
}
