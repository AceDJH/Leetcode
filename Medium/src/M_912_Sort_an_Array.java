/**
 * @Author AceDJH
 * @Date 2021/4/8 8:14
 */
public class M_912_Sort_an_Array {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end){
        if (start < end){
            int p = partition(nums, start, end);
            quickSort(nums, start, p - 1);
            quickSort(nums, p + 1, end);
        }
    }

    public int partition(int[] nums, int start, int end){
        int temp = nums[start];
        while (start < end){
            while (start < end && nums[end] >= temp){
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= temp){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }
}
