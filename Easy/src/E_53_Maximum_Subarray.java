/**
 * @Author AceDJH
 * @Date 2021/4/13 8:10
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class E_53_Maximum_Subarray {
    // O(n)解法
    /*public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            if (sum >= 0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }*/
    // 分治法，纯粹为了开拓思路
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right){
        if (left == right){
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftSum = mergeSort(nums, left, mid);
        int rightSum = mergeSort(nums, mid + 1, right);
        int midSum = merge(nums, left, mid, right);
        return Math.max(Math.max(leftSum, rightSum), midSum);
    }

    public int merge(int[] nums, int left, int mid, int right){
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        // i必须从中间开始算，因为此处是计算相邻处的最大子序和
        for (int i = mid; i >= left; i--){
            sum += nums[i];
            leftSum = Math.max(sum, leftSum);
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++){
            sum += nums[i];
            rightSum = Math.max(sum, rightSum);
        }
        return leftSum + rightSum;
    }
}
