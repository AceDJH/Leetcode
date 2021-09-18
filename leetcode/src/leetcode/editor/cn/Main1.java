package leetcode.editor.cn;

/**
 * @author AceDJH
 * @date 2021/9/13 6:00 下午
 */
public class Main1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,3,4,8,10};
        int[] nums1 = new int[]{3, 3,5 ,6 ,7, 8, 8, 8 ,8};
        System.out.println(getBiggerNums1(nums, 3));
        System.out.println(getBiggerNums1(nums1, 5));
    }

    public static int getBiggerNums(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            if (num > target){
                break;
            }
            count++;
        }
        return count;
    }

    // 0,1,2,3,4,5,6,7
    // 1,2,3,3,3,4,8,10
    public static int getBiggerNums1(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }
}
