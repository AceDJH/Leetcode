/**
 * @Author AceDJH
 * @Date 2021/1/14 9:29
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 *
 * 限制：
 *
 * 1 <= n <= 10000
 */
public class Offer64 {
    public static void main(String[] args) {
        int i = new Solution64().sumNums(3);
        System.out.println(i);
    }
}

// 利用短路运算， n为1时不调用sumNums
class Solution64 {
    int res = 0;
    public int sumNums(int n) {
        boolean b = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}