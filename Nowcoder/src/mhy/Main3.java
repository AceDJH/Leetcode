package mhy;

import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/9/12 10:02 下午
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int b2 = scanner.nextInt();
        int x = Math.abs(a1 - b1);
        int y = Math.abs(a2- b2);
        int dis = Math.max(x, y);
        System.out.println(dis % 3 == 0 ? dis / 3 : dis / 3 + 1);
    }
}
