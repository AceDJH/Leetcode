/**
 * @Author AceDJH
 * @Date 2020/12/15 9:19
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 */
public class Offer43 {
    public static void main(String[] args) {
        System.out.println(new Solution43().countDigitOne(12));
    }
}

class Solution43 {
    public int countDigitOne(int n) {
        if (n <= 0){
            return 0;
        }
        int digit = 1, high = n / 10;
        int cur = n % 10, low = 0;
        int sum = 0;
        while (high != 0 || cur != 0){
            if (cur == 0){
                sum += high * digit;
            }else if (cur == 1){
                sum += high * digit + low + 1;
            }else {
                sum += (high + 1) * digit;
            }
            low += cur * digit;
            digit *= 10;
            cur = high % 10;
            high = high / 10;
        }
        return sum;
    }
}
