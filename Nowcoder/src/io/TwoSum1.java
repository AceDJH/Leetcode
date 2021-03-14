package io;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2021/3/14 21:13
 * 计算a+b
 * 打开以下链接可以查看正确的代码
 * 1
 * https://ac.nowcoder.com/acm/contest/5657#question
 *
 * 输入描述:
 * 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
 *
 * 输出描述:
 * 输出a+b的结果
 *
 * 输入例子1:
 * 1 5
 * 10 20
 *
 * 输出例子1:
 * 6
 * 30
 */
public class TwoSum1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        while(sc.hasNextInt()){
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            System.out.println(num1 + num2);
        }
    }
}
