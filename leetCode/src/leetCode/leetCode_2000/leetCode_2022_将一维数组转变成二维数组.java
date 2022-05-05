package leetCode.leetCode_2000;

import java.util.Arrays;

public class leetCode_2022_将一维数组转变成二维数组 {
    public static void main(String[] args) {
        int [] original = {1,2,2,4};
        int m = 2;
        int n =2;
        System.out.println(Arrays.deepToString(construct2DArray(original, m, n)));
    }
    private static int[][] construct2DArray(int[] original, int m, int n) {
        int l = original.length;
        if(l!=m*n) {
            return new int[0][0];
        }
        int [][] todayIsNewYeay = new int[m][n];
        int year = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                todayIsNewYeay[i][j]=original[year++];
            }
        }
        return todayIsNewYeay;
}
}
