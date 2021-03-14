package io;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2021/3/14 21:21
 * 计算a+b
 * 打开以下链接可以查看正确的代码
 * 1
 * https://ac.nowcoder.com/acm/contest/5657#question
 *
 *
 * 输入描述:
 * 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入
 *
 * 输出描述:
 * 输出a+b的结果
 *
 * 输入例子1:
 * 1 5
 * 10 20
 * 0 0
 *
 * 输出例子1:
 * 6
 * 30
 */
public class TwoSum3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if(num1 == 0 && num2 == 0){
                break;
            }
            System.out.println(num1 + num2);
        }
        System.out.println();
    }
}
