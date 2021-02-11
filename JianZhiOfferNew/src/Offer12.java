/**
 * @Author AceDJH
 * @Date 2021/2/11 13:33
 */
public class Offer12 {
}

class Solution12 {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word  == null){
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isFind(board, rows, cols, i, j, word, pathLength, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFind(char[][] board, int rows, int cols, int row, int col, String word,
                          int pathLength, boolean[][] visited) {
        if (pathLength == word.length()){
            return true;
        }
        boolean find = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == word.charAt(pathLength)
            && !visited[row][col]){
            pathLength++;
            visited[row][col] = true;
            // 上下左右的顺序
            find = isFind(board, rows, cols, row - 1, col, word, pathLength, visited)
                    || isFind(board, rows, cols, row + 1, col, word, pathLength, visited)
                    || isFind(board, rows, cols, row, col - 1, word, pathLength, visited)
                    || isFind(board, rows, cols, row, col + 1, word, pathLength, visited);
            if (!find){
                --pathLength;
                visited[row][col] = false;
            }
        }
        return find;
    }
}
