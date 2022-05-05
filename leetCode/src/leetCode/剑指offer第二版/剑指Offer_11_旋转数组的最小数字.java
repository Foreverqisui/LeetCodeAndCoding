package leetCode.剑指offer第二版;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，
 * 并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 */
public class 剑指Offer_11_旋转数组的最小数字 {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};
        System.out.println(minArray(numbers));
    }

    private static int minArray(int[] numbers) {
        int n = numbers.length, l = 0, r = n - 1;
        while (l < r) {
            //求中间值
            int mid = (l + r) >> 1;
            //中间小于末尾时
            if (numbers[mid] < numbers[r]){
                r = mid;
            //中间大于末尾时
            }else if (numbers[mid] > numbers[r]){
                l = mid+1;
            //相等时
            }else{
                r-=1;
            }
        }
        return numbers[l];
    }
}
