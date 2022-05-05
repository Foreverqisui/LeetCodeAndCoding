package leetCode.leetCode_2000;


public class leetCode_1219_黄金矿工 {
    public static void main(String[] args) {
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        Solution s = new Solution();
        int maximumGold = s.getMaximumGold(grid);
        System.out.println(maximumGold);
    }

    static class Solution {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m, n;
        int res = 0;
        int[][] grid;

        private int getMaximumGold(int[][] grid) {
            this.grid = grid;
            this.m = grid.length;
            this.n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0) {
                        dfs(i, j, 0);
                    }
                }
            }
            return res;
        }

        private void dfs(int x, int y, int gold) {
            gold += grid[x][y];
            res = Math.max(res, gold);
            int rec = grid[x][y];
            grid[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > 0) {
                    dfs(nx, ny, gold);
                }
            }

            grid[x][y] = rec;

        }
    }
}
