package PDD;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2020/5/6 14:24
 */
public class Num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int num[] = new int[100000000];
        int n;
        boolean numBool[] = new boolean[100];
        for(int i = 0; i < n1; i++){
            Arrays.fill(num, 0);
            num[0] = sc.nextInt();
            num[1] = sc.nextInt();
            n = sc.nextInt();
            for (int j = 2; j <= n; j++) {
                num[j] = num[j - 1] + num[j - 2];
            }
            if (num[n] % 3 == 0){
                numBool[i] = true;
            }else {
                numBool[i] = false;
            }
        }
        for(int i = 0; i < n1; i++){
            if (numBool[i]){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
