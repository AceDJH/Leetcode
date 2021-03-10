/**
 * @Author AceDJH
 * @Date 2021/3/10 17:31
 */
public class Offer21New {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(new Solution21New().exchange(nums));
    }
}

class Solution21New {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }
        int ji = 0;
        int ou = nums.length - 1;
        while (ji < ou){
            while (ji < ou && nums[ji] % 2 == 1){
                ji++;
            }
            while (ji < ou && nums[ou] % 2 == 0){
                ou--;
            }
            swap(nums, ji, ou);
        }
        return nums;
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
