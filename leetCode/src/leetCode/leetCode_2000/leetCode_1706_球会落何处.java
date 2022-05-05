package leetCode.leetCode_2000;


import java.util.Arrays;

/**
 * 输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
 * 输出：[1,-1,-1,-1,-1]
 */
public class leetCode_1706_球会落何处 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        System.out.println(Arrays.toString(findBall(grid)));
    }

    private static int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int [] res = new int[n];
        for (int i = 0; i < n; i++) {
            int col = i;
            for(int[] row:grid) {
                int dir = row[col];
                col += dir;
                if (col < 0 || col ==n|| dir!=row[col]) {
                    col=-1;
                    break;
                }
            }
            res[i] = col;
        }
        return res;
    }
}
