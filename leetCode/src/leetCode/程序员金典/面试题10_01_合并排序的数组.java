package leetCode.程序员金典;

import java.util.Arrays;

import static sort.quickSort.swap;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
public class 面试题10_01_合并排序的数组 {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0}, B = {2, 5, 6};
        int m = 3, n = 3;
        merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }

    private static void merge(int[] suma, int m, int[] sumb, int n) {
        //结果数组 用来承接中间排序过程的结果
        int[] res = new int[m + n];
        //中间变量 用来找到每次的最小值
        int temp = 0;
        //双指针 初始化
        int la = 0, lb = 0;
        //双指针遍历
        while (la < m || lb < n) {
        //ps：要先判断边界，否则会有越界产生
            if (la == m) {
                //此时a走到头了
                temp = sumb[lb++];
            } else if (lb == n) {
                temp = suma[la++];
              //前小后大
            } else if (suma[la] < sumb[lb]) {
                //前面的向后移动
                temp = suma[la++];
            } else  {
                //后面的向后移动
                temp = sumb[lb++];
            }
            //中间结果
            res[la + lb - 1] = temp;
        }
        //结果转化
        if (res.length >= 0) {
            System.arraycopy(res, 0, suma, 0, res.length);
        }
    }
}
