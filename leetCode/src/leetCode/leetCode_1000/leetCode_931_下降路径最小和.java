package leetCode.leetCode_1000;

import java.util.Arrays;

public class leetCode_931_下降路径最小和 {
    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 7}, {7, 8, 9}};
        System.out.println(minFallingPathSum(matrix));
    }

    private static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < n; j++) {
                int best = matrix[i+1][j];
                if (j > 0) {
                    best = Math.min(best,matrix[i+1][j-1]);
                }
                if (j + 1 < n) {
                    best =Math.min(best,matrix[i+1][j+1]);
                }
                matrix[i][j] += best;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int c : matrix[0]
        ) {
            ans = Math.min(ans, c);
        }
        return ans;
    }
}
