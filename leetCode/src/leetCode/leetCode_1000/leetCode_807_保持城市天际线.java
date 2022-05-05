package leetCode.leetCode_1000;

public class leetCode_807_保持城市天际线 {
    public static void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    private static int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i]=Math.max(row[i],grid[i][j]);
                col[j]=Math.max(col[j],grid[i][j]);
            }
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans+=Math.min(row[i],col[j])-grid[i][j];
            }
        }
        return ans;
    }
}
