package dynamic;

/**
 * @author AceDJH
 * @date 2021/9/6 11:08 上午
 * 多重背包
 */
public class PackMultiple {
    public static void main(String[] args) {

    }

    // 直接修改01背包，进行朴素的解法

    /**
     *
     * @param capacity 背包容量
     * @param weight 各物品重量
     * @param value 各物品价值
     * @param nums 各物品数量
     * @return
     */
    public static int maxValue(int capacity, int[] weight, int[] value, int[] nums){
        int num = weight.length;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = capacity; j >= 1; j--) {
                // 相对于完全背包的朴素解法，多了个k <= nums[i - 1]的判断
                for(int k = 0; k <= nums[i - 1] && k * weight[i - 1] <= j; k++){
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i - 1]] + k * value[i - 1]);
                }
            }
            for (int k = 0; k < dp.length; k++) {
                System.out.print(dp[k] + " ");
            }
            System.out.println();
        }
        return dp[capacity];
    }
}
