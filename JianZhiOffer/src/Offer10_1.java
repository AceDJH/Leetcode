/**
 * @Author AceDJH
 * @Date 2020/5/22 12:19
 * 面试题10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 */
public class Offer10_1 {
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        System.out.println(new Solution10_1().fib(45));
    }
}
/*递归
class Solution10 {
    public int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}*/

class Solution10_1 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int one = 0;
        int two = 1;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum = (one + two) % 1000000007;
            one = two;
            two = sum;
        }
        return sum;
    }
}