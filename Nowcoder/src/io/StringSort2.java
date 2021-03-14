package io;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2021/3/14 22:41
 * 对输入的字符串进行排序后输出
 * 打开以下链接可以查看正确的代码
 * 1
 * https://ac.nowcoder.com/acm/contest/5657#question
 *
 *
 *
 * 输入描述:
 * 多个测试用例，每个测试用例一行。
 *
 * 每行通过空格隔开，有n个字符，n＜100
 *
 * 输出描述:
 * 对于每组测试用例，输出一行排序过的字符串，每个字符串通过空格隔开
 *
 * 输入例子1:
 * a c bb
 * f dddd
 * nowcoder
 *
 * 输出例子1:
 * a bb c
 * dddd f
 * nowcoder
 */
public class StringSort2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] s = sc.nextLine().split(" ");
            Arrays.sort(s);
            StringBuilder sb = new StringBuilder();
            for(String a : s){
                sb.append(a).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
