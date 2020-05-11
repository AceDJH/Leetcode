package PDD;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2020/5/6 14:11
 */
public class Box {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();
        if(num <= 1) System.out.println(0);
        int[] ball = new int[num];
        for (int i = 0; i < num; i++) {
            ball[i] = cin.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        int a = 0;
        for (int i = 0; i < num; i++) {
            int min = 1;
            if(set.contains(ball[i])){
                while (set.contains(ball[i]+min)){
                    min++;
                }
                set.add(ball[i]+min);
                a += min;
            }else {
                set.add(ball[i]);
            }
        }
        System.out.println(a);
    }
}
