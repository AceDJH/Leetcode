/**
 * @Author AceDJH
 * @Date 2020/10/13 21:49
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */
public class Offer29 {
}

class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0){
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] nums = new int[rows * columns];
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        int x = 0;
        while (left <= right || top <= bottom) {
            for (int i = left; i <= right; i++) {
                nums[x++] = matrix[top][i];
            }
            if (++top > bottom){
                break;
            }
            for (int i = top; i <= bottom; i++) {
                nums[x++] = matrix[i][right];
            }
            if (--right < left){
                break;
            }
            for (int i = right; i >= left; i--) {
                nums[x++] = matrix[bottom][i];
            }
            if (--bottom < top){
                break;
            }
            for (int i = bottom; i >= top; i--) {
                nums[x++] = matrix[i][left];
            }
            if (++left > right){
                break;
            }
        }
        return nums;
    }
}


