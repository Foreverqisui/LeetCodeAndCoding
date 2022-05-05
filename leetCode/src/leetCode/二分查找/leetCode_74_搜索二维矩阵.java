package leetCode.二分查找;

public class leetCode_74_搜索二维矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrix1(matrix, target));

    }

    /**
     * 二分查找
     */
    private static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int height = m * n - 1;
        while (low <= height) {
            int mid = (height - low) /2+low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                height = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }


    /**
     * 暴力求解
     */
    private static boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] < target) {
                    break;
                }
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

}
