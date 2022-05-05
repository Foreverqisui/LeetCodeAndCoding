package leetCode.剑指offer第二版;

import java.util.Arrays;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */

public class 剑指Offer_66_构建乘积数组 {
    public static void main(String[] args) {
        int[] a = {1, 2, 0, 4, 5};
        System.out.println(Arrays.toString(constructArr(a)));
    }

    private static int[] constructArr(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        //分成上下两个三角 分别迭代
        res[0] = 1;
        //首先计算下三角
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1]*a[i-1];
        }
        //其次计算下三角
        //中间值 用来存储上三角每一行的值，用来和上三角的做乘积
        int temp = 1;
        for (int i = n-2; i >= 0; i--) {
            temp*=a[i+1];
            res[i]*=temp;
        }
        return res;
    }
}
