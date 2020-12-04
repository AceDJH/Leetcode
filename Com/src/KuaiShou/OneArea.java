package KuaiShou;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2020/4/26 16:29
 */
/*

public class OneArea {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int x, y;
        x = cin.nextInt();
        y = cin.nextInt();
        if (x < 3 || y < 3) {
            System.out.println(0);
        }
        int[][] area = new int[x][y];
        // 判断这个点是否有可能形成1区域
        boolean[][] isPossible = new boolean[x][y];
        boolean[][] isUsed = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                area[i][j] = cin.nextInt();
            }
        }
        int sum = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || i == x - 1 || j == 0 || j == y - 1) {
                    if (area[i][j] == 1) {
                        isPossible[i][j] = false;
                    }
                }
                if (area[i][j] == 0) {
                    isPossible[i][j] = true;
                }
            }
        }
        // 边缘1不需要判断
        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {
                if (area[i][j] == 1) {
                    isUsed[i][j] = true;
                    if (area[i - 1][j - 1] == 0 || )
                }
            }
        }
    }
}
*/
