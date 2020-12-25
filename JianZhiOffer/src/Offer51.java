/**
 * @Author AceDJH
 * @Date 2020/12/25 11:24
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 */
public class Offer51 {
    public static void main(String[] args) {
        int[] nums = new int[]{7,5,6,4};
        System.out.println(new Solution51().reversePairs(nums));
    }
}

// 归并排序改
class Solution51 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        int len = nums.length;
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp){
        if (left >= right){
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = reversePairs(nums, left, mid, temp);
        int rightCount = reversePairs(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]){
            return leftCount + rightCount;
        }
        int crossCount = mergeAndCount(nums, left, mid, right, temp);
        return leftCount + rightCount + crossCount;
    }

    /**
     * 左右分组已经有序，统计左右合并后的逆序数
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp){
        if (left >= right){
            return 0;
        }
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left, j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1){
                nums[k] = temp[j++];
            } else if (j == right + 1){
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]){
                nums[k] = temp[i++];
            }else {
                nums[k] = temp[j++];
                count += (mid - i + 1);
            }
        }
        return count;
    }
}