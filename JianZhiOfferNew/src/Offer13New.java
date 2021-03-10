/**
 * @Author AceDJH
 * @Date 2021/3/10 14:28
 */
public class Offer13New {
}

class Solution13New {
    int rows, columns;
    int max;
    public int movingCount(int m, int n, int k) {
        boolean[][] canReach = new boolean[m][n];
        rows = m;
        columns = n;
        max = k;
        return reach(0, 0, canReach);
    }

    public int reach(int row, int column, boolean[][] canReach){
        int count = 0;
        if (row >= 0 && column >= 0 && row < rows && column < columns && !canReach[row][column] && getTwoNumSum(row, column) <= max){
            canReach[row][column] = true;
            count += 1 + reach(row - 1, column, canReach)
                + reach(row + 1, column, canReach)
                + reach(row, column - 1, canReach)
                + reach(row, column + 1, canReach);
        }
        return count;
    }

    public int getNumSum(int a){
        int sum = 0;
        while (a != 0){
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

    public int getTwoNumSum(int a, int b){
        return getNumSum(a) + getNumSum(b);
    }
}