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
 *
 * 每行不定有n个整数，空格隔开。(1 <= n <= 100)。
 *
 * 输出描述:
 * 每组数据输出求和的结果
 *
 * 输入例子1:
 * 1 2 3
 * 4 5
 * 0 0 0 0 0
 *
 * 输出例子1:
 * 6
 * 9
 * 0
 */
public class TwoSum7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] s = sc.nextLine().split(" ");
            int sum = 0;
            for(String a : s){
                sum += Integer.parseInt(a);
            }
            System.out.println(sum);
        }
    }
}
