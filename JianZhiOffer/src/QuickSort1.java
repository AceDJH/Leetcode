/**
 * @Author AceDJH
 * @Date 2020/11/12 22:03
 */
public class QuickSort1 {
    public static void main(String[] args) {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = (int) (1000 * Math.random());
        }
        for (int num : nums) {
            System.out.print(num + "   ");
        }
        System.out.println("------------------");
        new QuickSort1().quickSort1(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + "   ");
        }
    }

    public void quickSort1(int[] nums, int start, int end){
        if (start < end){
            int pivot = partition(nums, start, end);
            quickSort1(nums, start, pivot - 1);
            quickSort1(nums, pivot + 1, end);
        }
    }

    public int partition(int[] nums, int start, int end){
        if (nums.length <= 0 || start < 0 || end >= nums.length){
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
