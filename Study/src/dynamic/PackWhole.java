package dynamic;

/**
 * @author AceDJH
 * @date 2021/9/5 10:00 下午
 * 完全背包
 */
public class PackWhole {
    public static void main(String[] args) {
        int[] weight = new int[]{2, 3, 4, 7};
        int[] value = new int[]{1, 3, 5, 9};
        System.out.println(maxValue1(10, weight, value));
    }
    // 直接修改01背包，进行朴素的解法
    public static int maxValue(int capacity, int[] weight, int[] value){
        int num = weight.length;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = capacity; j >= 1; j--) {
                // 由于k的计算方式，因此if (j >= weight[i - 1])这个判断可以删掉
                for(int k = 0; k <= j / weight[i - 1]; k++){
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

    public static int maxValue1(int capacity, int[] weight, int[] value){
        int num = weight.length;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = weight[i - 1]; j <= capacity; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j - weight[i - 1]] + value[i - 1]);
            }
            for (int k = 0; k < dp.length; k++) {
                System.out.print(dp[k] + " ");
            }
            System.out.println();
        }

        return dp[capacity];
    }
}
