/**
 * @Author AceDJH
 * @Date 2021/3/13 15:27
 */
public class Offer39New {
}

class Solution39New {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur){
                count++;
                if (count > nums.length / 2){
                    return cur;
                }
            }else {
                count--;
                if (count == 0){
                    cur = nums[i];
                    count = 1;
                }
            }
        }
        return cur;
    }
}
