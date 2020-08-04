/**
 * @Author AceDJH
 * @Date 2020/6/26 23:03
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
public class M_79_Word_Search {
}

class Solution79 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1 || word.length() < 1) {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean visited[][] = new boolean[rows][cols];
        int pathLength = 0;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (hasPathCore(board, rows, cols, row, col, word, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPathCore(char[][] board, int rows, int cols, int row, int col, String word,
                               int pathLength, boolean[][] visited) {
        if (pathLength == word.length()) {
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols &&
                board[row][col] == word.charAt(pathLength) && !visited[row][col]) {
            ++pathLength;
            visited[row][col] = true;

            hasPath = hasPathCore(board, rows, cols, row, col - 1, word, pathLength, visited)
                    || hasPathCore(board, rows, cols, row, col + 1, word, pathLength, visited)
                    || hasPathCore(board, rows, cols, row - 1, col, word, pathLength, visited)
                    || hasPathCore(board, rows, cols, row + 1, col, word, pathLength, visited);
            if (!hasPath) {
                --pathLength;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}
