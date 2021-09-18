/**
 * @author AceDJH
 * @date 2021/9/10 9:33 下午
 */
public class Offer12New1 {
    class Solution {
        String word;
        char[][] board;
        int rows, lines;
        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0){
                return false;
            }
            this.board = board;
            this.word = word;
            this.rows = board.length;
            this.lines = board[0].length;
            boolean[][] isVisited = new boolean[rows][lines];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < lines; j++) {
                    if (dfs(isVisited, 0, i, j)){
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean dfs(boolean[][] isVisited, int len, int i, int j){
            if (len == word.length()){
                return true;
            }
            if (i < 0 || i >= rows || j < 0 || j >= lines || isVisited[i][j] ||
                    board[i][j] != word.charAt(len)){
                return false;
            }
            isVisited[i][j] = true;
            len++;
            if (dfs(isVisited, len, i + 1, j) ||
                    dfs(isVisited, len, i - 1, j) ||
                    dfs(isVisited, len, i, j + 1) ||
                    dfs(isVisited, len, i, j - 1)){
                return true;
            }
            isVisited[i][j] = false;
            return false;
        }
    }
}
