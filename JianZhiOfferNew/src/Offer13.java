/**
 * @Author AceDJH
 * @Date 2021/2/11 14:14
 */
public class Offer13 {
    public static void main(String[] args) {
        System.out.println(new Solution13().movingCount(38, 15, 9));
    }
}

class Solution13 {
    public int movingCount(int m, int n, int k) {
        if (m < 0 || n < 0 || k < 0){
            return -1;
        }
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        count = count(m, n, 0, 0, k, visited);
        return count;
    }

    public int count(int rows, int cols, int row, int col, int k, boolean[][] visited){
        int count = 0;
        if (row >= 0 && row < rows && col >= 0 && col < cols && sumAll(row, col) <= k && !visited[row][col]){
            visited[row][col] = true;
            count += 1 + count(rows, cols, row - 1, col, k, visited)
                    + count(rows, cols, row + 1, col, k, visited)
                    + count(rows, cols, row, col - 1, k, visited)
                    + count(rows, cols, row, col + 1, k, visited);
        }
        return count;
    }

    public int sumNum(int num){
        int sum = 0;
        if (num / 10 != 0){
            sum += num % 10;
            num = num / 10;
        }
        sum += num;
        return sum;
    }

    public int sumAll(int num1, int num2){
        return sumNum(num1) + sumNum(num2);
    }
}