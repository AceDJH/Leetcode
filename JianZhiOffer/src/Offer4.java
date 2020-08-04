/**
 * @Author AceDJH
 * @Date 2020/5/11 20:56
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer4 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-5}};
        System.out.println(new Solution4().findNumberIn2DArray(matrix, -10));
    }
}

class Solution4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean isFound = false;
        if (matrix.length <= 0) {
            return isFound;
        }
        int rows = matrix.length - 1;
        int columns = matrix[0].length - 1;
        int row = 0;
        int column = columns;
        while (row <= rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                isFound = true;
                break;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return isFound;
    }
}