package hw;

import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/8/25 7:36 下午
 */
public class Main2 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int col = s.nextInt();
        int[][] times = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                times[i][j] = s.nextInt();
            }
        }
        minPath(times, 0, 0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void minPath(int[][] times, int row, int col, int time){
        int rows = times.length;
        int cols = times[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols ||
            times[row][col] - time <= 0) {
            return;
        }
        if (row == rows - 1 && col == cols - 1){
            min = Math.min(min, time);
        }
        minPath(times, row - 1, col, time + 1);
        minPath(times, row + 1, col, time + 1);
        minPath(times, row, col - 1, time + 1);
        minPath(times, row, col + 1, time + 1);
    }

   /* public static void minPath(int[][] times, int row, int col, int time, int temp){
        int rows = times.length;
        int cols = times[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols ||
                times[row][col] - time <= 0){
            return;
        }
        if (row == rows - 1 && col == cols - 1){
            steps = Math.max(temp, steps);
        }
        minPath(times, row - 1, col, time + 1, temp + 1);
        minPath(times, row + 1, col, time + 1, temp + 1);
        minPath(times, row, col - 1, time + 1, temp + 1);
        minPath(times, row, col + 1, time + 1, temp + 1);
    }*/
}
