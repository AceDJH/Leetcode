/**
 * @Author AceDJH
 * @Date 2021/1/11 9:07
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *
 *
 * 限制：
 *
 * 1 <= n <= 11
 */
public class Offer60 {
    public static void main(String[] args) {
        float a = 6;
        float num = 1 / (float)36;
        float num1 = 1 / a;
        double[] doubles = new Solution60().dicesProbability(2);
        for (double aDouble : doubles) {
            System.out.print(aDouble + " ");
        }
    }
}

class Solution60 {
    /**
     * 我们先建立二维 dp 数组，dp[n][s] 表示投掷 n 个骰子，n 个朝上的面的点数之和为 s 的事件出现的次数。
     * 那么动态转移方程就是：dp[n][s] += dp[n - 1][s - k]，k 属于 [1, 6]
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        // 为了方便表达，我们将 dp 数组的行的数量设为 n + 1，列的数量设为 6n + 1。行表示 n，列表示 s，且 s 的最大值是 6n。
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        /**
         * num 为当前使用的骰子数
         * sum 为num个骰子可以掷出的和
         * digit 为第num个骰子掷出的点数
         */
        for (int num = 2; num <= n; num++){
            for (int sum = num; sum <= 6 * num; sum++){
                for (int digit = 1; digit <= 6; digit++){
                    if (sum - digit > 0){
                        dp[num][sum] += dp[num - 1][sum - digit];
                    }else {
                        break;
                    }
                }
            }
        }
        // 和的结果值最小为n，最大为6n，所有可能值为6 * n - n + 1
        double[] ans = new double[6 * n - n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = dp[n][i] / Math.pow(6, n);
        }
        return ans;
    }
}
