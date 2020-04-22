package DuXiaoMan;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n, m, a, b;
        n = cin.nextInt();
        m = cin.nextInt();
        a = cin.nextInt();
        b = cin.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                nums[i - 1][j - 1] = i * j % 10;
            }
        }
        int sum = 0;
        int newRow = n - a + 1;
        int newLine = m - b + 1;
        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newLine; j++) {
                int max = 0;
                for (int k = 0; k < a; k++){
                    for (int q = 0; q < b; q++){
                        // 这里一定要剪枝，不然就会超时
                        if (max == 9){
                            break;
                        }
                        max = Math.max(max, nums[i + k][j + q]);
                    }
                }
                sum += max;
            }
        }
        System.out.println(sum);
    }
}
