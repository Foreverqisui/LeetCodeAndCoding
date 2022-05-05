package leetCode.剑指Offer;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，arr1 和 arr2，
 *
 *     arr2 中的元素各不相同
 *     arr2 中的每个元素都出现在 arr1 中
 *
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * */
public class 剑指Offer_075_数组相对排序 {

    public static void main(String[] args) {
        int [] arr1={2,3,1,3,2,4,6,7,9,2,19},arr2={2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    /**
     * 计数排序
     * */
    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        //优化：不需要1001数组，而是最大值+1
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }

        //对arr1中的词频出现次数进行统计
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }

        //按照arr2的顺序进行排序
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            //意味着这个地方排序过了
            frequency[x] = 0;
        }

        //插入arr1特有的元素
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;

    }
}
