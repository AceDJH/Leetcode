package xhw;

import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/9/13 9:21 上午
 * 4 4
 * 0 -2 -7 0
 * 9 2 -6 2
 * -4 1 -4 1
 * -1 8 0 -2
 */
public class MainNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int lines = scanner.nextInt();
        int[][] matrix = new int[rows][lines];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < lines; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println(maxValue(matrix));
    }

    public static int maxValue(int[][] matrix){
        int rows = matrix.length;
        int lines = matrix[0].length;
        int[][] sumRows = new int[rows][lines];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < rows; j++) {
                if (j == 0){
                    sumRows[j][i] = matrix[j][i];
                }else {
                    sumRows[j][i] = matrix[j][i] + sumRows[j - 1][i];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < rows; j++) {
                int[] sum = new int[lines];
                for (int k = 0; k < lines; k++) {
                    if (i == 0){
                        sum[k] = sumRows[i][k];
                    }else {
                        sum[k] = sumRows[j][k] - sumRows[i - 1][k];
                    }
                }
                int subMax = subMax(sum);
                max = Math.max(max, subMax);
            }
        }
        return max;
    }

    public static int subMax(int[] nums){
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum >= 0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
