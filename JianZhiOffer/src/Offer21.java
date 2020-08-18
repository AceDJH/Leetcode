/**
 * @Author AceDJH
 * @Date 2020/8/18 22:36
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer21 {
    public static void main(String[] args) {
        System.out.println(new Solution21().exchange(new int[]{1, 2, 3, 4})[1]);
    }
}

class Solution21 {
    public int[] exchange(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && ((nums[start] & 1) != 0)){
                start++;
            }
            while (start < end && ((nums[end] & 1) == 0)){
                end--;
            }
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        return nums;
    }
}