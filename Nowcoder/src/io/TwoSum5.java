package io;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2021/3/14 21:46
 * 计算一系列数的和
 * 打开以下链接可以查看正确的代码
 * 1
 * https://ac.nowcoder.com/acm/contest/5657#question
 *
 *
 *
 * 输入描述:
 * 输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。
 * 接下来t行, 每行一组数据。
 * 每行的第一个整数为整数的个数n(1 <= n <= 100)。
 * 接下来n个正整数, 即需要求和的每个正整数。
 *
 * 输出描述:
 * 每组数据输出求和的结果
 *
 * 输入例子1:
 * 2
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 *
 * 输出例子1:
 * 10
 * 15
 */
public class TwoSum5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int num = sc.nextInt();
            int count = 0;
            while(num > 0){
                int a = sc.nextInt();
                count += a;
                num--;
            }
            t--;
            System.out.println(count);
        }
    }
}
