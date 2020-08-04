/**
 * @Author AceDJH
 * @Date 2020/3/25 22:51
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_69_Sqrtx {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution69().mySqrt(2147395599));
    }
}

class Solution69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int low = 2, high = x / 2;
        int mid;
        long a1;
        while (low <= high) {
            mid = (low + high) / 2;
            // 关键是这一步的强转为long，保证不丢失位数
            a1 = (long) mid * mid;
            if (a1 > x) {
                high = mid - 1;
            } else if (a1 < x) {
                low = mid + 1;
            } else
                return mid;
        }
        return high;

    }
}
