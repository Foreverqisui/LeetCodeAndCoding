package leetCode.leetCode_100;

public class leetCode_62_不同路径 {
    public static void main(String[] args) {
        int m=3;
        int n=7;
        System.out.println(uniquePaths(m,n));
    }

    private static int uniquePaths(int m, int n) {
        int [][]nums=new int[m][n];
        for (int i = 0; i < n; i++) {nums[0][i]=1;}
        for (int i = 0; i < m; i++) {nums[i][0]=1;}
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j]=nums[i-1][j]+nums[i][j-1];
            }
        }
        return nums[m-1][n-1];
    }
}
