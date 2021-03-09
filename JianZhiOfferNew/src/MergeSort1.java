/**
 * @Author AceDJH
 * @Date 2021/3/9 13:52
 */
public class MergeSort1 {
    public static void main(String[] args) {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = (int) (1000 * Math.random());
        }
        for (int num : nums) {
            System.out.print(num + "   ");
        }
        System.out.println("------------------");
        int[] temp = new int[100];
        new MergeSort1().sort(nums, 0, nums.length - 1, temp);
        for (int num : nums) {
            System.out.print(num + "   ");
        }
    }

    public void sort(int[] nums, int start, int end, int[] temp){
        if (start < end){
            int middle = start + (end - start) / 2;
            sort(nums, start, middle, temp);
            sort(nums, middle + 1, end, temp);
            merge(nums, start, middle, end, temp);
        }
    }

    public void merge(int[] nums, int start, int middle, int end, int[] temp){
        if (start >= end){
            return;
        }
        for (int i = start; i <= end; i++){
            temp[i] = nums[i];
        }
        int left = start;
        int j = middle + 1;
        while (start <= middle && j <= end){
            if (temp[start] <= temp[j]){
                nums[left++] = temp[start++];
            }else {
                nums[left++] = temp[j++];
            }
        }
        while (start <= middle){
            nums[left++] = temp[start++];
        }
        while (j <= end){
            nums[left++] = temp[j++];
        }
    }
}
