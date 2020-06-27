/**
 * @Author AceDJH
 * @Date 2020/6/27 23:13
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class Offer13 {
    public static void main(String[] args) {
        System.out.println(new Solution13().movingCount(1, 2, 1));
    }
}

class Solution13 {
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0){
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        count = movingCountCore(m, n, 0, 0, k, visited);
        return count;
    }

    public int movingCountCore(int rows, int cols, int row, int col, int k, boolean[][] visited){
        int count = 0;
        if (row >= 0 && row < rows && col >= 0 && col < cols &&
                (getDigitSum(row) + getDigitSum(col)) <= k && !visited[row][col]){
            visited[row][col] = true;
            count = 1 + movingCountCore(rows, cols, row + 1, col, k, visited)
                    + movingCountCore(rows, cols, row - 1, col, k, visited)
                    + movingCountCore(rows, cols, row, col + 1, k, visited)
                    + movingCountCore(rows, cols, row, col - 1, k, visited);
        }
        return count;
    }

    public int getDigitSum(int number){
        int sum = 0;
        while (number != 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
