/**
 * @Author AceDJH
 * @Date 2020/12/26 18:36
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class Offer53_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(new Solution53_1().search(nums, 8));
    }
}

class Solution53_1 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int index = targetIndex(nums, target, 0, nums.length - 1);
        int count = 0;
        if (index != -1){
            int left = index - 1;
            while (left >= 0 && nums[left] == target){
                count++;
                left--;
            }
            int right = index + 1;
            while (right <= nums.length - 1 && nums[right] == target){
                count++;
                right++;
            }
            count++;
            return count;
        }
        return count;
    }

    public int targetIndex(int[] nums, int target, int start, int end){
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
