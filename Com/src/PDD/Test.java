package PDD;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2020/5/6 15:06
 * 用来测评牛客网的输入输出
 */
// 评判错误
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a + b);
    }
}

/*评判正确
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//此处为评判正确的关键
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
*/
