package leetCode.数组;

import java.util.HashSet;
import java.util.Set;

public class leetCode_36_有效的数独 {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));

    }


    /**
     * 暴力+哈希
     * */
    private static boolean isValidSudoku(char[][] board) {
        Set<String> sudoku = new HashSet<String>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] !='.'){
                    String s = "("+board[i][j]+")";
                    if (!sudoku.add(i+s)||!sudoku.add(s+j)||!sudoku.add(i/3+s+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
