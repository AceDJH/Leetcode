import java.util.Arrays;

/**
 * @Author AceDJH
 * @Date 2020/3/8 22:55
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// 还未完成，明日再看
public class MW_322_Coin_Change {
    public static void main(String[] args) {
        int[] coins = {2, 5, 1};
        new Solution().coinChange(coins, 2);
    }
}

/*想着用贪心的思想做，但是有问题，比如考虑到有 [1,7,10] 这种用例，按照贪心思路 10 + 1 + 1 + 1 + 1 会比 7 + 7 更早找到
因此需要利用贪心+dfs来做，具体做法看大佬的：https://leetcode-cn.com/problems/coin-change/solution/322-by-ikaruga/
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int num = 0;
        int i = coins.length - 1;
        while (amount >= 0 && i >= 0){
            if (amount - coins[i] >= 0){
                amount -= coins[i];
                num++;
            }else {
                i--;
            }
        }
        if (amount == 0)
            return num;
        return -1;
    }
}*/

/*动态规划：自下而上*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        //确保没存数值时最大
        int max = amount + 1;
        int[] dp = new int[amount + 1];//因为不仅有dp[0], 还要有dp[amount];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++){
                if (coins[j] <= i){
                    dp[i] = Math.min( dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;

    }
}

