/**
 * @Author AceDJH
 * @Date 2020/12/15 10:48
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 */
public class Offer44 {
    public static void main(String[] args) {
        // System.out.println(new Solution44().getNumber(1000, 0));
        System.out.println(new Solution44().findNthDigit(1000000000));
        // System.out.println(Math.pow(10, 2));
    }
}

class Solution44 {
    public int findNthDigit(int n) {
        if (n <= 0){
            return 0;
        }
        int digit = 1;
        long sum = 0;
        long high = 10, low = 1;
        while (true){
            sum = sum + (high - low) * digit;
            if (sum >= n){
                break;
            }else {
                high *= 10;
                low *= 10;
                digit++;
            }
        }
        long start = sum - (high - low) * digit + 1;
        long distance = n - start;
        long position = distance / digit;
        int index = (int) (distance % digit);
        long realNum = low + position;
        int num = getNumber(realNum, index);
        return num;
    }

    public int getNumber(long num, int index){
        char c = String.valueOf(num).charAt(index);
        int a = Integer.parseInt(String.valueOf(c));
        return a;
    }
}
