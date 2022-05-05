package leetCode.剑指Offer;

/**
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。
 * 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 */
public class 剑指Offer_112_最长递增路径 {
    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        Solution sol = new Solution();
        System.out.println(sol.longestIncreasingPath(matrix));
    }

    static class Solution {
        public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int rows, columns;
        //因为朴素dfs超时，所以采用记忆化dfs
        //加上一个缓存矩阵
        public int longestIncreasingPath(int[][] matrix) {
            //数组为空判断
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            //行 列长度
            rows = matrix.length;
            columns = matrix[0].length;
            //缓存矩阵
            int[][] memo = new int[rows][columns];
            int ans = 0;
            //遍历求得结果
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    //调用函数，获得最大路径
                    ans = Math.max(ans, dfs(matrix, i, j, memo));
                }
            }
            return ans;
        }

        public int dfs(int[][] matrix, int row, int column, int[][] memo) {
            //缓存矩阵为空判断
            //如果 memo[i][j]≠0 说明该单元格的结果已经计算过，则直接从缓存中读取结果
            if (memo[row][column] != 0) {
                return memo[row][column];
            }
            //对缓存矩阵赋值
            ++memo[row][column];
            //移动位置 进行赋值
            for (int[] dir : dirs) {
                //进行移动 上下左右四个方向
                int newRow = row + dir[0], newColumn = column + dir[1];
                //边界判断--不出边界的值
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns &&
                    //题意要求递增，所以判断是否满足要求
                    matrix[newRow][newColumn] > matrix[row][column]) {
                    //将大的值放入缓存矩阵里
                    memo[row][column] = Math.max(memo[row][column],
                            dfs(matrix, newRow, newColumn, memo) + 1);
                }
            }
            return memo[row][column];
        }
    }
}
