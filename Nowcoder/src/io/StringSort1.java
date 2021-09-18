package io;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2021/3/14 22:08
 * 对输入的字符串进行排序后输出
 * 打开以下链接可以查看正确的代码
 * 1
 * https://ac.nowcoder.com/acm/contest/5657#question
 *
 *
 *
 * 输入描述:
 * 输入有两行，第一行n
 *
 * 第二行是n个空格隔开的字符串
 *
 * 输出描述:
 * 输出一行排序后的字符串，空格隔开，无结尾空格
 *
 * 输入例子1:
 * 5
 * c d a bb e
 *
 * 输出例子1:
 * a bb c d e
 */
public class StringSort1 {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");

        Arrays.sort(s);
        StringBuilder sb = new StringBuilder();
        for(String a : s){
            sb.append(a).append(" ");
        }
        System.out.println(sb.toString().trim());
        //System.out.println(String.join(" ",s));
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] s = new String[num];
        for (int i = 0; i < num; i++) {
            s[i] = sc.next();
        }
        Arrays.sort(s);
        StringBuilder sb = new StringBuilder();
        for(String a : s){
            sb.append(a).append(" ");
        }
        System.out.println(sb.toString().trim());
        //System.out.println(String.join(" ",s));
    }
}
