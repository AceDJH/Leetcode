package Ali;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2021/3/15 19:05
 * 今日的笔试题
 */
public class ALi {
    public static void main(String[] args) {
        // System.out.println(2 | 1);
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // 最后若有问题，改为long
        while (t > 0){
            long a  = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            t--;
            System.out.println(reverseCount(a, b, c));
        }
    }

    public static int reverseCount(long a, long b, long c){
        int count = 0;
        long d = a | b;
        for (int i = 0; i < 64; i++) {
            if (((d & 1) == 1 && (c & 1) == 1) || ((d & 1) == 0 && (c & 1) == 0)){
                count = count;
            }
            if ((d & 1) == 1 && (c & 1) == 0){
                if ((a & 1) == 1){
                    count++;
                }
                if ((b & 1) == 1){
                    count++;
                }
            }
            if ((d & 1) == 0 && (c & 1) == 1){
                count++;
            }
            d = d >> 1;
            c = c >> 1;
            a = a >> 1;
            b = b >> 1;
        }
        return count;
    }
}
