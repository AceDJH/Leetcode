

/**
 * @Author AceDJH
 * @Date 2020/12/24 11:02
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 *
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 */
public class Offer49 {
    public static void main(String[] args) {
        System.out.println(new Solution49().nthUglyNumber(77));
    }
}

class Solution49 {
    public int nthUglyNumber(int n) {
        if (n <= 0){
            return 0;
        }
        int[] nums = new int[n];
        int num2 = 0, num3 = 0, num5 = 0;
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = nums[num2] * 2;
            int n3 = nums[num3] * 3;
            int n5 = nums[num5] * 5;
            nums[i] = Math.min(Math.min(n2 ,n3), n5);
            if (nums[i] == n2){
                num2++;
            }
            if (nums[i] == n3){
                num3++;
            }
            if (nums[i] == n5){
                num5++;
            }
        }
        return nums[n - 1];
    }
}
