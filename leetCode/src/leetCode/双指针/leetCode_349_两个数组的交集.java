package leetCode.双指针;

import java.util.Arrays;

public class leetCode_349_两个数组的交集 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4};
        int[] nums2 = {1, 2, 1, 1};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        int[] nums = new int[n + m];
        int a = 0;
        int b = 0;
        int c = 0;
        while (b < n && c < m) {
            int n1 = nums1[b];
            int n2 = nums2[c];
            if (n1 == n2) {
                if (a == 0 || n1 != nums[a - 1]) {
                    nums[a++] = n1;
                }
                b++;
                c++;
            } else if (n1 < n2) {
                b++;
            } else {
                c++;
            }
        }
        return Arrays.copyOfRange(nums, 0, a);
    }

}
