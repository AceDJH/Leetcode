package xhw;

import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/8/25 6:59 下午
 * 4 4
 * 0 -2 -7 0
 * 9 2 -6 2
 * -4 1 -4 1
 * -1 8 0 -2
 */
public class Main {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = s.nextInt();
            }
        }
        System.out.println(maxValue(nums));

    }

    public static int maxValue(int[][] nums){
        int rows = nums.length;
        int lines = nums[0].length;
        int[][] a = nums;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < lines; j++) {
                a[i][j] += a[i - 1][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = i; j < rows; j++) {
                int[] sum = new int[lines];
                for (int k = 0; k < lines; k++) {
                    if (i == 0){
                        sum[k] = a[j][k];
                    }else {
                        // 求得第i行到第j行的每列的列和
                        sum[k] = a[j][k] - a[i - 1][k];
                    }
                }
                int max = maxSub(sum);
                maxValue = Math.max(max, maxValue);
            }
        }
        return maxValue;
    }

    public static int maxSub(int[] sum){
        int[] maxSub = new int[sum.length];
        int max = Integer.MIN_VALUE;
        maxSub[0] = sum[0];
        for (int i = 1; i < sum.length; i++) {
            maxSub[i] = (maxSub[i - 1] > 0) ? (maxSub[i - 1] + sum[i]): sum[i];
            max = Math.max(max, maxSub[i]);
        }
        return max;
    }
}
