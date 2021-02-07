/**
 * @Author AceDJH
 * @Date 2021/2/7 18:57
 */
public class Offer4 {
    public static void main(String[] args) {
        int[][] nums = new int[2][3];
        System.out.println(nums[0].length);

    }
}

class Solution4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int rowIndex = 0;
        int columnIndex = column - 1;
        int value;
        while (rowIndex < row && columnIndex >=0){
            value = matrix[rowIndex][columnIndex];
            if (value == target){
                return true;
            }else if (value < target){
                rowIndex++;
            }else {
                columnIndex--;
            }
        }
        return false;
    }
}
