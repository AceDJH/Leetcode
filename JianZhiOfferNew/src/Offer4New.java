/**
 * @Author AceDJH
 * @Date 2021/3/9 14:25
 */
public class Offer4New {
}

class Solution4New {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null){
            return false;
        }
        int row = matrix.length;
        if (row == 0){
            return false;
        }
        int line = matrix[0].length;
        if (line == 0){
            return false;
        }
        int i = 0, j = line - 1;
        while (i < row && j >= 0){
            int temp = matrix[i][j];
            if (target == temp){
                return true;
            }
            if (target < temp){
                j--;
            }
            if (target > temp){
                i++;
            }
        }
        return false;
    }
}
