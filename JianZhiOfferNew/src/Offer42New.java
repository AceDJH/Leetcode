/**
 * @Author AceDJH
 * @Date 2021/3/15 12:21
 */
public class Offer42New {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (dp[i - 1] + nums[i] < nums[i]){
                dp[i] = nums[i];
            }else {
                dp[i] = nums[i] + dp[i - 1];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
