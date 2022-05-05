package leetCode.leetCode_500;

public class leetCode_221_最大正方形 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix));
    }

    private static int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return maxSize;
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j]=Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSize=Math.max(dp[i][j],maxSize);
                }

            }
        }
        return maxSize * maxSize;
    }
}
