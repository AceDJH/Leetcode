/**
 * @Author AceDJH
 * @Date 2020/5/18 22:25
 * 快速排序的实现
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

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    // 快排中进行划分的函数
    public int partition(int[] nums, int start, int end) {
        if (nums.length <= 0 || start < 0 || end >= nums.length) {
            throw new RuntimeException();
        }
        // 防止最差情况
        int index = (int) (start + Math.random() * (end - start));
        int temp1 = nums[index];
        nums[index] = nums[start];
        nums[start] = temp1;

        int temp = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= temp) {
                --end;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= temp) {
                ++start;
            }
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }
}
