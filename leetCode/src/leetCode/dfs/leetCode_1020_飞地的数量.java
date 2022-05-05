package leetCode.dfs;

public class leetCode_1020_飞地的数量 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        System.out.println(numEnclaves(grid));
    }
    /*
     * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
     *
     * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
     *
     * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
     * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
     * 输出：3
     * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
     * */

    /**
     * 二维数组题标准初始化
     */
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int m, n;
    private static boolean[][] visited;

    private static int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        //边界放进去进行dfs 判断与边界连接的地方是啥玩意
        //对行边界进行判断
        for (int i = 0; i < m; i++) {
            //要找到左边界
            dfs(grid,i,0);
            //要找到最右边的边界 所以要借助列数-1来找
            dfs(grid,i,n-1);
        }
        //对列边界进行判断 和行边界同理
        for (int i = 0; i < n; i++) {
            dfs(grid,0,i);
            dfs(grid,m-1,i);
        }
        int res = 0;
        //对整个网格进行判断，找到飞地也就是被包围的地方
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                //找到网格中为陆地，并且没有和边界关联的地方
                if (grid[i][j]==1&&!visited[i][j]){
                    res++;
                }
            }
        }
        return res;
    }


    private static void dfs(int[][] grid,int row,int col) {

        /*
         *条件判断：
         * 边界条件，判断是否为边界 行上边界下边界 列的左边界有边界
         * 规则条件：要为陆地也就是1，才能往下进行dfs
         * 此地是否已经存在过了，因为可能在别的遍历的时候遍历过了
         * */
        if(row < 0 || row>= m || col < 0||col>=n||grid[row][col]==0||visited[row][col]){
            return;
        }
        //将和边界串联在一起的地方，联系在一起，这样下次循环遍历整个网格时，就可以判断此地是否为飞地
        visited[row][col] = true;
        for(int[]dir :dirs) {
            dfs(grid,row+dir[0],col+dir[1]);
        }
    }
}
