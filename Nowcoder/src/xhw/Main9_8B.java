package xhw;

import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/9/8 8:36 下午
 * 重合时间最多的时间段
 * 6
 * 10 15 55 60 10 40 5 15 5 10 25 55
 * 输出 10 15
 */
public class Main9_8B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] start = new int[num];
        int[] end = new int[num];
        for (int i = 0; i < num; i++) {
            start[i] = scanner.nextInt();
            end[i] = scanner.nextInt();
        }
        maxTime(start, end);
    }

    public static void maxTime(int[] start, int[] end){
        int count = 1;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < start.length; i++) {
            int temp = 1;
            int tempStart = 0, tempEnd = 0;
            for (int j = i + 1; j < start.length; j++) {
                if (start[i] < end[j] && end[i] > start[j]) {
                    temp++;
                    tempStart = Math.max(start[i], start[j]);
                    tempEnd = Math.min(end[i], end[j]);
                }
            }
            if (temp > count){
                count = temp;
                maxStart = tempStart;
                maxEnd = tempEnd;
            }
        }
        System.out.print(maxStart + " " + maxEnd);
    }
}
