import java.util.Arrays;

/**
 * @Author AceDJH
 * @Date 2021/1/4 9:53
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 *
 */
public class Offer56_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution56_1().singleNumbers(new int[]{4, 1, 4, 6})));
    }
}

class Solution56_1 {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        int index = 1;
        while ((index & res) == 0){
            index = index << 1;
        }
        int a = 0, b= 0;
        for (int num : nums) {
            if ((index & num) == 0){
                a = a ^ num;
            }else {
                b = b ^ num;
            }
        }
        return new int[]{a, b};
    }
}