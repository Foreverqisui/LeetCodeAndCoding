package leetCode.剑指Offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 * <p>
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * <p>
 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,0]
 * 输出：1
 */
public class 剑指Offer_069_山峰数组的顶部 {
    public static void main(String[] args) {
        int[] arr = {0,1,0};
/*        System.out.println(peakIndexInMountainArray(arr));*/
        System.out.println(peakIndexInMountainArray1(arr));
    }

    /**
     * 复杂度：O（n）
     * */
    private static int peakIndexInMountainArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        return map.get(arr[arr.length - 1]);
    }
    /**
     * 复杂度：O（logn）
     * */
    private static int peakIndexInMountainArray1(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
