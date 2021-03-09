/**
 * @Author AceDJH
 * @Date 2021/3/9 15:38
 */
public class Offer11New {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5};
        System.out.println(new Solution11New().minArray(nums));
    }
}

class Solution11New {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0){
            return 0;
        }
        return division(numbers, 0, numbers.length - 1);
    }

    public int division(int[] nums, int start, int end){
        int mid = start;
        while (nums[start] >= nums[end]){
            if (end - start <= 1){
                mid = end;
                return nums[mid];
            }
            mid = start + (end - start) / 2;
            if (nums[start] == nums[end] && nums[start] == nums[mid]){
                int min = nums[start];
                for(int i = start + 1; i < end; i++){
                    min = Math.min(nums[i], min);
                }
                return min;
            }
            if (nums[mid] >= nums[start]){
                start = mid;
            }
            if (nums[mid] <= nums[end]){
                end = mid;
            }
        }
        return nums[mid];
    }
}
