package leetCode.leetCode_1000;

public class leetCode_794_有效的井字游戏 {
    public static void main(String[] args) {
        String[] board = {"XOX","O O","XOX"};
        System.out.println(validTicTacToe(board));
    }

    private static boolean validTicTacToe(String[] board) {
        int o=0;int x=0;
        for (String c:board
             ) {
            for (char d:c.toCharArray()
                 ) {
                x=(d=='X')?x+1:x;
                o=(d=='O')?o+1:o;
            }
        }
        if (o!=x&&o!=x-1) return false;
        if (win(board,'X')&&o!=x-1)return false;
        if (win(board,'O')&& o!=x) return false;
        return true;
    }
    private static boolean win(String[]board ,char p){
        for (int i = 0; i < 3; i++) {
            if (p==board[0].charAt(i)&&p==board[1].charAt(i)&&p==board[2].charAt(i)){
                return true;
            }
            if (p==board[i].charAt(0)&&p==board[i].charAt(1)&&p==board[i].charAt(2)){
                return true;
            }
        }
        if (p==board[0].charAt(0)&&p==board[1].charAt(1)&&p==board[2].charAt(2)) return true;
        if (p==board[0].charAt(2)&&p==board[1].charAt(1)&&p==board[2].charAt(0)) return true;
        return false;
    }
}
