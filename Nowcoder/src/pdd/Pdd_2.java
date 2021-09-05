package pdd;

import java.util.Scanner;



/**
 * @author AceDJH
 * @date 2021/8/22 7:20 下午
 */
public class Pdd_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            System.out.println(2);
        }
        for(int i = 0; i < t; i++){
            int n = scanner.nextInt();
            int[] scores = new int[n];
            int[] days = new int[n];
            for (int j = 0; j < n; j++) {
                scores[j] = scanner.nextInt();
                days[j] = scanner.nextInt();
                System.out.println(maxDayScores(scores, days));
            }
        }
    }

    public static int maxDayScores(int[] score, int[] days){
        int maxDay = 0;
        for (int i = 0; i < days.length; i++) {
            maxDay = Math.max(maxDay, days[i]);
        }
        int[] goods = new int[maxDay + 1];
        for (int i = maxDay; i > 0; i--) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < days.length; j++) {
                if (days[j] >= i){
                    if (score[j] >= max){
                        max = score[j];
                        index = j;
                    }
                }
            }
            days[index] = 0;
            goods[i] = max;
        }
        int sum = 0;
        for (int good : goods) {
            sum += good;
        }
        return sum;
    }
}
