/**
 * @Author AceDJH
 * @Date 2021/1/6 10:17
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 *
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 */
public class Offer57 {
    public static void main(String[] args) {
        int[] nums = new int[]{16,16,18,24,30,32};
        int[] twoSum = new Solution57().twoSum(nums, 48);
        System.out.println(twoSum[0] + " + " + twoSum[1]);
    }
}

class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int index = lessTargetIndex(nums, target, 0, nums.length - 1);
        for (int i = 0; i <= index; i++) {
            for (int j = index; j > i; j--){
                // 判断条件最好不要用相加后的结果，应该用target - nums[i] 跟 nums[j]比较，这样保证不会溢出。
                if (target - nums[i] == nums[j]){
                    return new int[]{nums[i], nums[j]};
                }
                if (target - nums[i] > nums[j]){
                    break;
                }
            }
        }
        return null;
    }

    private int lessTargetIndex(int[] nums, int target, int start, int end){
        int oldEnd = end;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] >= target){
                if (nums[mid - 1] <= target){
                    return mid;
                }else {
                    end = mid - 1;
                }
            }else {
                start = mid + 1;
            }
        }
        if (start >= oldEnd){
            return start - 1;
        }
        return start;
    }
}

class Solution57Better {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j){
            int s = target - nums[j];
            if (s > nums[i]){
                i++;
            }else if (s < nums[i]){
                j--;
            }else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return null;
    }
}