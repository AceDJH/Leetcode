/**
 * @Author AceDJH
 * @Date 2021/3/9 16:41
 */
public class Offer12New {
    public static void main(String[] args) {
        char[][] c= {{'a','b','c'},{'d','e','f'},{'g','h','k'}};
        System.out.println(new Solution12New().exist(c, "beh"));
    }
}

class Solution12New {
    String words;
    int rows, columns;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        words = word;
        rows = board.length;
        columns = board[0].length;
        boolean[][] isVisited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (isFind(board, i, j, isVisited, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFind(char[][] board, int row, int column, boolean[][] isVisited, int num){
        if (num == words.length()){
            return true;
        }
        if (row >= 0 && row < rows && column >= 0 && column < columns && !isVisited[row][column]
            && board[row][column] == words.charAt(num)){
            isVisited[row][column] = true;
            num++;
            if (isFind(board, row - 1, column, isVisited, num) ||
            isFind(board, row + 1, column, isVisited, num) ||
            isFind(board, row, column - 1, isVisited, num) ||
            isFind(board, row, column + 1, isVisited, num)){
                return true;
            }else {
                isVisited[row][column] = false;
                return false;
            }
        }
        return false;
    }
}
