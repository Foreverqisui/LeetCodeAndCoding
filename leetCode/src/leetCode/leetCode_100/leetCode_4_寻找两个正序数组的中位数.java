package leetCode.leetCode_100;

import java.util.Arrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * */
public class leetCode_4_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int [] nums1 = {1,2},nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] sum = new int[nums1.length+nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            sum[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            sum[i+nums1.length] = nums2[i];
        }
        Arrays.sort(sum);
        double res = 0.0;
        for (int i = 0; i < sum.length; i++) {
            int left = 0,right = sum.length-1;
            int mid = (left + right)>>1;
            if (sum.length%2==0){
                res = (sum[mid]+sum[mid+1])/2.0;
            }else{
                res = sum[mid];
            }
        }

        return res;
    }
}
