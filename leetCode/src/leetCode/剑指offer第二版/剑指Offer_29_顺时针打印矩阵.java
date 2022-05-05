package leetCode.剑指offer第二版;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class 剑指Offer_29_顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }

    private static int[] spiralOrder(int[][] matrix) {
        //为空判断
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        //四个边界
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        //结果索引
        int x = 0;
        //结果变量
        int[] res = new int[(right + 1) * (bottom + 1)];
        //遍历
        while (true) {
            //从左往右
            for (int i = left; i <= right; i++) {
                //top行 i列
                res[x++] = matrix[top][i];
            }
            //判断是否可以继续往下走 是否已经到底了
            if (++top > bottom) {
                break;
            }
            //从上往下
            for (int i = top; i <= bottom; i++) {
                //行 right列
                res[x++] = matrix[i][right];
            }
            //判断是否可以往左走
            if (left > --right) {
                break;
            }
            //从右往左
            for (int i = right; i >= left; i--) {
                //bottom行 i列
                res[x++] = matrix[bottom][i];
            }
            //判断是否可以往上走
            if (top > --bottom) {
                break;
            }
            //从下到上
            for (int i = bottom; i >= top; i--) {
                //i行 left列
                res[x++] = matrix[i][left];
            }
            //判断是否可以从左往右走
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
