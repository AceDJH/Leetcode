/**
 * @Author AceDJH
 * @Date 2020/7/1 23:44
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * <p>
 * 2 <= n <= 58
 */
public class Offer14_1 {
}

/*
// 动态规划
class Solution14_1 {
    public int cuttingRope(int n) {
        if (n < 2){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }

        int[] maxProduct = new int[n + 1];
        // 这几个基础值很关键，它们代表的不是乘积，而是基底
        maxProduct[0] = 0;
        maxProduct[1] = 1;
        maxProduct[2] = 2;
        maxProduct[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = maxProduct[j] * maxProduct[i - j];
                if (product > max){
                    max = product;
                }
            }
            maxProduct[i] = max;
        }
        return maxProduct[n];
    }
}*/

// 贪心算法
class Solution14_1 {
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timesOf3 = n / 3;
        if (n - 3 * timesOf3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
