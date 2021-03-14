package io;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2021/3/14 21:17
 * 计算a+b
 * 打开以下链接可以查看正确的代码
 * 1
 * https://ac.nowcoder.com/acm/contest/5657#question
 *
 *
 * 输入描述:
 * 输入第一行包括一个数据组数t(1 <= t <= 100)
 * 接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
 *
 * 输出描述:
 * 输出a+b的结果
 *
 * 输入例子1:
 * 2
 * 1 5
 * 10 20
 *
 * 输出例子1:
 * 6
 * 30
 */
public class TwoSum2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            System.out.println(num1 + num2);
            t--;
        }
    }
}
