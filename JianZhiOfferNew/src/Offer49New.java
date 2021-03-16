/**
 * @Author AceDJH
 * @Date 2021/3/16 10:18
 */
public class Offer49New {
    public int nthUglyNumber(int n) {
        if (n <= 6){
            return n;
        }
        int[] nums = new int[n];
        int num2 = 0, num3 = 0, num5 = 0;
        nums[0] = 1;
        for (int i = 1; i < n; i++){
            int two = nums[num2] * 2;
            int three = nums[num3] * 3;
            int five = nums[num5] * 5;
            nums[i] = Math.min(Math.min(two, three), five);
            if (nums[i] == two){
                num2++;
            }
            if (nums[i] == three){
                num3++;
            }
            if (nums[i] == five){
                num5++;
            }
        }
        return nums[n - 1];
    }
}
