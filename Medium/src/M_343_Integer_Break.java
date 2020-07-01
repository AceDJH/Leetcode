/**
 * @Author AceDJH
 * @Date 2020/7/2 0:25
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class M_343_Integer_Break {
}

class Solution343 {
    public int integerBreak(int n) {
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
}
