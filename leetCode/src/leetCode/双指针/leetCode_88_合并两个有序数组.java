package leetCode.双指针;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 双指针
 */
public class leetCode_88_合并两个有序数组 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        int m = 3;
        int n = 3;

//        System.out.println(Arrays.toString(merageTwoSum(a, m, b, n)));
        System.out.println(Arrays.toString(merageTwoSum1(a, m, b, n)));
    }


    /**
     * 大神
     * 从后往前比较，因为是有序数组，大的一定在后面
     */
    private static int[] merageTwoSum1(int[] nums1, int m, int[] nums2, int n) {
        int tail = m - 1;
        int tail2 = n - 1;
        int finished = m + n - 1;
        while (tail >= 0 && tail2 >= 0) {
            nums1[finished--] = nums1[tail] > nums2[tail2] ? nums1[tail--] : nums2[tail2--];
        }
        //如果nums2长则直接拼在nums1后面
        while (tail2 >= 0) {
            nums1[finished--] = nums2[tail2--];
        }
        return nums1;

    }

    /**
     * 双指针
     * 从头到尾反复比较
     */
    private static int[] merageTwoSum(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int l = nums1.length + nums2.length;
        int[] a = new int[l];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            a[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; i++) {
            nums1[i] = a[i];
        }
        return nums1;
    }
}
