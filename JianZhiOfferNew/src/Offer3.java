/**
 * @Author AceDJH
 * @Date 2021/2/7 18:19
 */
public class Offer3 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 0, 4, 5, 6, 7, 8, 9};
        System.out.println(new Solution3().findRepeatNumber(nums));
    }
}

// 萝卜占坑思路
class Solution3 {
    public int findRepeatNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i){
                // 如果当前萝卜nums[i]，要去占的坑nums[i]，坑里的萝卜nums[nums[i]]与它一样，则说名重复
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }
}