package leetCode.剑指Offer;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * */
public class 剑指Offer_098_路径的数目 {
    public static void main(String[] args) {
        int m = 3,n=7;
        System.out.println(uniquePaths(m,n));
    }
    private static int uniquePaths(int m, int n) {
        //构建矩阵
        int [][] dp = new int[m][n];
        //分析一下，求得是路径和，只需要将每个位置通过的数目做总和即可
        //限定了只能往右下两个方向走，所以限制了方向
        //先把横竖边界的行和列置为1 -- 因为是边界且不能往上走，所以只能为1
        for(int i =0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i =0;i<n;i++){
            dp[0][i]=1;
        }
        //开始向下走
        for(int i =1;i<m;i++){
            for(int j=1;j<n;j++){
                //当前位置通过的路径是左边通过的路径数+上边通过的路径数
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
