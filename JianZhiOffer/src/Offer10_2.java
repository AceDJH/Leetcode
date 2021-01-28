/**
 * @Author AceDJH
 * @Date 2021/1/28 10:18
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 */
public class Offer10_2 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution10_2Better().numWays(46));
    }

}

class Solution10_2 {
    public int numWays(int n) {
        int[] num = new int[n + 2];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            num[i] = (num[i - 1] + num[i - 2])  % 1000000007;
        }
        return num[n];
    }
}

class Solution10_2Better {
    public int numWays(int n) {
        int one = 1;
        int two = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = (one + two) % 1000000007;
            one = two;
            two = temp;
        }
        return two;
    }
}