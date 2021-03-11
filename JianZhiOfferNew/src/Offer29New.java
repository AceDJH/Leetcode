/**
 * @Author AceDJH
 * @Date 2021/3/11 16:12
 */
public class Offer29New {
}

class Solution29New {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] nums = new int[rows * columns];
        int left = 0, right = columns - 1;
        int top = 0, bottom = rows - 1;
        int k = 0;
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++){
                nums[k++] = matrix[top][i];
            }
            if (++top > bottom){
                break;
            }
            for (int i = top; i <= bottom; i++){
                nums[k++] = matrix[i][right];
            }
            if (--right < left){
                break;
            }
            for (int i = right; i >= left; i--){
                nums[k++] = matrix[bottom][i];
            }
            if (--bottom < top){
                break;
            }
            for (int i = bottom; i >= top; i--){
                nums[k++] = matrix[i][left];
            }
            if (++left > right){
                break;
            }
        }
        return nums;
    }
}
