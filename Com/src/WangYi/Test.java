package WangYi;

import java.util.Arrays;

/**
 * @Author AceDJH
 * @Date 2020/11/17 18:58
 * 5个，不能连续取2个，动态规划
 * 1 5 3 2 6
 * 最多的盗取方案 5 + 6
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 3, 2, 6};
        System.out.println(maxSum(nums));
    }

    public static int maxSum(int[] array){
        if (array == null || array.length == 0){
            return 0;
        }
        if (array.length == 1){
            return array[0];
        }
        if (array.length == 2){
            return Math.max(array[0], array[1]);
        }
        int[] array1 = Arrays.copyOf(array, array.length + 1);
        int[] maxsum = new int[array.length];
        maxsum[0] = array[0];
        maxsum[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            maxsum[i] = Math.max(maxsum[i - 1], maxsum[i - 2] + array[i]);
        }
        return maxsum[array.length - 1];
    }
}
