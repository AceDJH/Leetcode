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
 * 输入数据有多组, 每行表示一组输入数据。
 * 每行的第一个整数为整数的个数n(1 <= n <= 100)。
 * 接下来n个正整数, 即需要求和的每个正整数。
 *
 * 输出描述:
 * 每组数据输出求和的结果
 *
 * 输入例子1:
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 *
 * 输出例子1:
 * 10
 * 15
 */
public class TwoSum6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int sum = 0;
            while(n > 0){
                sum += sc.nextInt();
                n--;
            }
            System.out.println(sum);
        }
    }
}
