/**
 * @Author AceDJH
 * @Date 2020/5/25 17:04
 * 154. 寻找旋转排序数组中的最小值 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 注意数组中可能存在重复的元素。
 *
 * 示例 1：
 *
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 *
 * 输入: [2,2,2,0,1]
 * 输出: 0
 */
public class H_154_Find_Minimum_in_Rotated_Sorted_Array_II {
}

class Solution154 {
    public int findMin(int[] nums) {
        if (nums.length <= 0){
            throw new RuntimeException();
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = left;
        while (nums[left] >= nums[right]){
            if (right - left == 1){
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            if (nums[left] == nums[right] && nums[left] == nums[mid]){
                int min = nums[left];
                for (int i = left + 1; i <= right; i++){
                    if (nums[i] < min){
                        min = nums[i];
                        break;
                    }
                }
                return min;
            }
            if (nums[mid] >= nums[left]){
                left = mid;
            }
            if (nums[mid] <= nums[right]){
                right = mid;
            }
        }
        return nums[mid];
    }
}
