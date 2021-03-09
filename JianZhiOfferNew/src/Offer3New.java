/**
 * @Author AceDJH
 * @Date 2021/3/9 14:17
 */
public class Offer3New {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(new Solution3New().findRepeatNumber(nums));
    }
}

class Solution3New {
    public int findRepeatNumber(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            temp[nums[i]] = ++temp[nums[i]];
            if (temp[nums[i]] > 1){
                return nums[i];
            }
        }
        return 0;
    }
}
