package io;

import java.util.Scanner;

/**
 * @Author AceDJH
 * @Date 2021/3/14 22:51
 * 每年前几场在线笔试编程题的时候，总有同学询问为什么我本地测试通过，自测也通过，提交代码系统却返回通过率0。
 * 打开以下链接可以查看正确的代码
 * 1
 * https://ac.nowcoder.com/acm/contest/5657#question
 * 这不是系统的错，可能是因为
 * 1.你对题目理解错了，你的代码只过了样例或你自己的数据
 * 2.你的代码逻辑有问题，你的代码只过了样例或你自己的数据
 * 总之就是你的代码只是过了样例和自测数据，后台的测试数据你根本不可见，要多自己思考。
 *
 * 这个题目如果你提交后通过率为0，又觉得自己代码是正确的，可以 点击查看 通过的代码
 *
 * 谨记：
 * 当你笔试的时候怀疑系统或者题目数据有问题的时候请务必先怀疑自己的代码!
 * 当你笔试的时候怀疑系统或者题目数据有问题的时候请务必先怀疑自己的代码!
 *
 * 请帮忙把这个练习专题发给你的朋友同学吧，感谢感谢
 *
 * 输入描述:
 * 输入有多组测试用例，每组空格隔开两个整数
 *
 * 输出描述:
 * 对于每组数据输出一行两个整数的和
 *
 * 输入例子1:
 * 1 1
 *
 * 输出例子1:
 * 2
 */
public class TwoSum8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] s = sc.nextLine().split(" ");
            long a = Long.parseLong(s[0]);
            long b = Long.parseLong(s[1]);
            System.out.println(a + b);
        }

    }
}
