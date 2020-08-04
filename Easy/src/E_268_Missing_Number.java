/**
 * @Author AceDJH
 * @Date 2020/2/23 16:40
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E_268_Missing_Number {
}

/*看到题发现这不就是等差数列吗，算就完事了
class Solution268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            sum += num;
            if (num > max)
                max = num;
        }
        if (max != nums.length)
            return nums.length;
        int sum2 = max * (1 + max) / 2;
        return sum2 - sum;
    }
}*/

//官方解里与我思路相同的一种，不过代码更简洁，而且命名更好
class Solution268 {
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}