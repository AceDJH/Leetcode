/**
 * @Author AceDJH
 * @Date 2021/1/28 10:38
 * 剑指 Offer 14- II. 剪绳子 II  此题困难在于大数求余
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
public class Offer14_2 {
    public static void main(String[] args) {
        System.out.println(new Solution14_2().cuttingRope(120));
    }
}

/**
 * 模运算与基本四则运算有些相似，但是除法例外。其规则如下：
 *
 *  (a + b) % p = (a % p + b % p) % p
 *
 * （1） (a - b) % p = (a % p - b % p) % p
 *
 * （2） (a * b) % p = (a % p * b % p) % p
 *
 * （3） a ^ b % p = ((a % p)^b) % p
 *
 * （4） 结合律： ((a+b) % p + c) % p = (a + (b+c) % p) % p
 *
 * （5） ((a*b) % p * c)% p = (a * (b*c) % p) % p
 *
 * （6） 交换律： (a + b) % p = (b+a) % p
 *
 * （7） (a * b) % p = (b * a) % p
 *
 * （8） 分配律： ((a +b)% p * c) % p = ((a * c) % p + (b * c) % p) % p
 */
class Solution14_2 {
    public int cuttingRope(int n) {
        if (n <= 3){
            return n - 1;
        }
        // 由于timesOf3可能会很大，因此在计算指数时可能溢出，即使用long
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1){
            timesOf3--;
        }
        // 此处的long也需要注意
        long res = 1;
        for (int i = 0; i < timesOf3; i++) {
            res = res * 3;
            res = res  % 1000000007;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) ((res * Math.pow(2, timesOf2)) % 1000000007);
    }
}
