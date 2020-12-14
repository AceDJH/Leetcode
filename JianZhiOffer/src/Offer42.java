/**
 * @Author AceDJH
 * @Date 2020/12/14 21:32
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Offer42 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution42().maxSubArray(nums));
    }
}

class Solution42 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] < nums[i]){
                sum = nums[i];
                if (nums[i] > max){
                    max = nums[i];
                }
            }else {
                if (sum + nums[i] > max){
                    max = sum + nums[i];
                }
                if (sum + nums[i] > 0){
                    sum = sum + nums[i];
                }else {
                    sum = nums[i];
                }
            }
        }
        return max;
    }
}
