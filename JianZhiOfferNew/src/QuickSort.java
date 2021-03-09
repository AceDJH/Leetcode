/**
 * @Author AceDJH
 * @Date 2021/3/9 13:38
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = (int) (1000 * Math.random());
        }
        for (int num : nums) {
            System.out.print(num + "   ");
        }
        System.out.println("------------------");
        new QuickSort().quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + "   ");
        }
    }

    public void quickSort(int[] nums, int start, int end){
        if (start < end){
            int middle = partition(nums, start, end);
            quickSort(nums, start, middle - 1);
            quickSort(nums, middle + 1, end);
        }
    }

    public int partition(int[] nums, int start, int end){
        if (nums == null || start < 0 || end >= nums.length){
            throw new RuntimeException();
        }
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
