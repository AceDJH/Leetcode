/**
 * @Author AceDJH
 * @Date 2021/3/10 16:23
 */
public class Offer17New {
}

class Solution17New {
    public int[] printNumbers(int n) {
        int max = (int) (Math.pow(10, n) - 1);
        int[] nums = new int[max];
        for (int i = 0; i < max; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}
