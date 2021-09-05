package xhw;

import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/9/1 7:19 下午
 */

public class Main9_1A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] nums = new int[length][2];
        for (int i = 0; i < length; i++) {
            String[] split = sc.next().split(",");
            nums[i][0] = Integer.parseInt(split[0]);
            nums[i][1] = Integer.parseInt(split[1]);
        }
        int count = sc.nextInt();

    }

    public static int minNum(int[][] nums, int count){
        int minCount = Integer.MAX_VALUE;

        return minCount;
    }
}
