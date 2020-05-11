package KuaiShou;

import java.util.Scanner;

/**
 * 给定一组石头，每个石头有一个正数的重量。每一轮开始的时候，选择两个石头一起碰撞，假定两个石头的重量为x，y，x<=y,碰撞结果为
 * 1. 如果x==y，碰撞结果为两个石头消失
 * 2. 如果x != y，碰撞结果两个石头消失，生成一个新的石头，新石头重量为y-x
 *
 * 最终最多剩下一个石头为结束。求解最小的剩余石头质量的可能性是多少。
 * 思路：！！！ 转换成0-1背包问题
 * 把石头分为两堆，从A堆中取出一块石头m，B堆中取出n，不妨设m>=n。碰撞后碎片为m-n，应放入A堆。
 * 对比碰撞前后，你会发现两个堆的质量之差没有发生变化。并且重复碰撞下去直到只剩一堆的时候，剩下的质量就是两堆之差,求两堆之差的最小值
 *假设B堆的质量和tolB<sum/2
 * tolA-tolB = sum -tolB-tolB=sum-2*tolB min ->max(tolB)
 * 所以问题就转换成求tolB<=sum/2的情况下的最大值  ->0-1背包问题 背包容量sum/2，物品n个 将n个物品装入容量为sum/2的背包中，使得背包的容量利用的最好
 * 最后两堆之差最小值=sum-2*tolB
 */
public class Stone {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();
        int[] tone = new int[num];
        int sum = 0;
        for (int i = 0; i < num; i++) {
            tone[i] = cin.nextInt();
            sum += tone[i];
        }
        //0-1背包问题
        int capcity = sum/2;
        int[][] dp = new int[num][capcity+1];
        //第0个物品可以放下则放下dp[0][i]=tone[0]否则dp[0][i]为0；
        for (int i = 0; i <=capcity; i++) {
            dp[0][i] = (tone[0]>i)?0:tone[0];
        }

        for (int i = 1; i < num; i++) {
            for (int j = 0; j <= capcity; j++) {
                if(j>=tone[i]){//可以放下
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-tone[i]]+tone[i]);
                }else {//放不下
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int min = sum - 2*dp[num-1][sum/2];
        System.out.println(min);
    }
}
