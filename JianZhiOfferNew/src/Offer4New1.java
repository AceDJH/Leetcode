/**
 * @author AceDJH
 * @date 2021/9/10 5:37 下午
 */
public class Offer4New1 {

    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0){
                return false;
            }
            int rows = matrix.length;
            int lines = matrix[0].length;
            int i = 0, j = lines - 1;
            while (i < rows && j >= 0){
                if (matrix[i][j] == target){
                    return true;
                }else if (matrix[i][j] > target){
                    j--;
                }else {
                    i++;
                }
            }
            return false;
        }
    }
}


