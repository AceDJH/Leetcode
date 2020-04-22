package DuXiaoMan;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2020/4/20 15:12
 */
public class Test {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a, b, c;
        a = cin.nextInt();
        b = cin.nextInt();
        c = cin.nextInt();
        int sum = a + b;
        if (sum > c){
            System.out.println("No");
        }else {
            int sub = sum - c;
            if (sub % 2 == 0){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
