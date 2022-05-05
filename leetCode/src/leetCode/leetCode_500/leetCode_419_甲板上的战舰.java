package leetCode.leetCode_500;

public class leetCode_419_甲板上的战舰 {
    public static void main(String[] args) {
        char[][] board= {{'X', '.', '.', 'X'},{'.', '.', '.', 'X'},{'.', '.', '.', 'X'}};
        System.out.println(countBattleships(board));
    }

    private static int countBattleships(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int ans=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i>0 &&board [i-1][j]=='X'){
                    continue;
                }
                if (j>0&&board[i][j-1]=='X'){
                    continue;
                }
                if (board[i][j]=='X'){
                    ans++;
                }
            }
        }
        return ans;
    }
}
