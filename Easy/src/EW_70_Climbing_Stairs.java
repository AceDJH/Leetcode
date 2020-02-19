/**
 * @Author AceDJH
 * @Date 2020/2/19 13:08
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EW_70_Climbing_Stairs {
    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(1));
    }
}
//以下都为官方给的解法

/*使用递归，暴力解，但是提交发现超出时间限制
class Solution70 {
    public int climbStairs(int n) {
        return climb(0, n);
    }

    public int climb(int i, int n){
        if (i == n)
            return 1;
        if (i > n)
            return 0;
        return climb(i + 1, n) + climb(i + 2, n);
    }
}*/

/*空间换时间，用数组记忆中间结果，时间要求被满足
class Solution70 {
    public int climbStairs(int n) {
        int[] memo = new int[n];
        return climb(0, n, memo);
    }

    public int climb(int i, int n, int memo[]){
        if (i == n)
            return 1;
        if (i > n)
            return 0;
        if (memo[i] > 0)
            return memo[i];
        memo[i] =  climb(i + 1, n, memo) + climb(i + 2, n, memo);
        return memo[i];
    }
}*/

// 动态规划
class Solution70 {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
