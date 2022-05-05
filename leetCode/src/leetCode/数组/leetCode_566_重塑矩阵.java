package leetCode.数组;

import java.util.Arrays;

public class leetCode_566_重塑矩阵 {
    public static void main(String[] args) {
        int[][]mat = {{1, 2}, {3, 4}};
        int r = 1, c = 4;
        System.out.println(Arrays.deepToString(matrixReshape(mat, r, c)));
    }
    private static int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length,col=mat[0].length;
        if (row*col!=r*c){
            return mat;
        }
        int [][] newMatrix = new int[r][c];
        for (int i = 0; i < row * col; i++) {
            //把原数组的列上的值给新数组
            newMatrix[i/c][i%c]=mat[i/col][i%col];
        }
        return newMatrix;
    }
}
