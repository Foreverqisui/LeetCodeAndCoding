package leetCode.leetCode_500;

import java.util.Arrays;

/**
 * 轮转数组
 * 数组翻转
 */
public class leetCode_189_轮转数组 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int k = 5;
        rotate(arr,k);
    }

   //数组翻转
    private static void rotate(int[] arr, int k) {
            k%=arr.length;
        reserve(arr, 0, arr.length - 1);
        reserve(arr, 0, k - 1);
        reserve(arr, k, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reserve(int[] arr, int i, int i1) {
        while (i < i1) {
            int temp = arr[i];
            arr[i] = arr[i1];
            arr[i1] = temp;
            i += 1;
            i1 -= 1;
        }
    }
}