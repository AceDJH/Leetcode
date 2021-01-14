/**
 * @Author AceDJH
 * @Date 2021/1/14 10:27
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 */
public class Offer65 {
    public static void main(String[] args) {
        int a = 3;
        int b = a << 1;
        int c = a << 2;
        System.out.println(a + " " + b + " " + c);
        int d = a & b;
        System.out.println(d);
    }
}

class Solution65 {
    public int add(int a, int b) {
        return Integer.sum(a, b);
    }
}

class Solution65Normal {
    // 不需要特地去求补数，因为 在计算机系统中，数值一律用 补码 来表示和存储。
    public int add(int a, int b) {
        // 若有进位，则c不为0，则b不为0，会进入下次循环，再做求和。
        while (b != 0){
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
