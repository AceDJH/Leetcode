/**
 * @Author AceDJH
 * @Date 2021/3/16 9:40
 */
public class Offer47New {
    public static void main(String[] args) {
    }
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] values = new int[rows][columns];
        values[0][0] = grid[0][0];
        // 最上面一行
        for (int i = 1; i < columns; i++){
            values[0][i] = values[0][i - 1] + grid[0][i];
        }
        // 最左列
        for (int i = 1; i < rows; i++){
            values[i][0] = values[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < rows; i++){
            for (int j = 1; j < columns; j++){
                values[i][j] = Math.max(values[i - 1][j], values[i][j - 1]) + grid[i][j];
            }
        }
        return values[rows - 1][columns - 1];
    }
}
