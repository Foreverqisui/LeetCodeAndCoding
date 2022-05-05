package leetCode.剑指offer第二版;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * */
public class 剑指Offer_12_矩阵中的路径 {
    public static void main(String[] args) {

    }
    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length,n = board[0].length;
            //将字符串转成char数组
            char[] words = word.toCharArray();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board,i,j,words,0)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, char []word,int n) {
            //递归终止条件--找到目标元素 || 索引越界 || 对应位置的值不相等
            if (n==word.length){
                return true;
            }
            if (i>=board.length || i<0 || j>=board[0].length || j<0 || board[i][j] != word[n] ){
                return false;
            }
            //四个方向 都走 找到能走的位置
            boolean res = dfs(board, i+1, j, word,n+1) || dfs(board, i-1, j, word, n+1)
                    || dfs(board, i, j+1, word, n+1) || dfs(board, i, j-1, word, n+1);
            return res;
        }
    }
}
