package leetCode.leetCode_1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode_1380_矩阵中的幸运数 {
    public static void main(String[] args) {
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println(luckyNumbers(matrix));
    }

    /**
     * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
     * 输出：[15]
     * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值
     */
    private static List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix.length,m=matrix[0].length;
        int[] max=new int[m],min=new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               max[j] = Math.max(max[j],matrix[i][j]);
               min[i] = Math.min(min[i],matrix[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max[j]==matrix[i][j]&&min[i]==matrix[i][j]){
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }
}
