package dynamic;

/**
 * @author AceDJH
 * @date 2021/9/5 6:52 下午
 * 01背包问题
 */
public class Pack01 {
    public static void main(String[] args) {
        int[] weight = new int[]{2, 3, 4, 7};
        int[] value = new int[]{1, 3, 5, 9};
//        System.out.println(maxValue(10, weight, value));
        System.out.println(maxValue1(10, weight, value));
    }

    /**
     * 二维dp解法
     * @param capacity
     * @param weight
     * @param value
     * @return
     */
    public static int maxValue(int capacity, int[] weight, int[] value){
        int num = weight.length;
        int[][] dp = new int[num + 1][capacity + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j >= weight[i - 1]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= capacity; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[num][capacity];
    }

    /**
     * 一维dp解法
     * @param capacity
     * @param weight
     * @param value
     * @return
     */
    public static int maxValue1(int capacity, int[] weight, int[] value){
        int num = weight.length;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= num; i++) {
            // 递推的时候从后往前,原因是若是从前往后推，则会出现,i = 1, j = 4
            // 类似dp[4] = Math.max(dp[4], dp[4 - weight[0]] + value[0]);
            // 即dp[4] = Math.max(dp[4], dp[2] + value[0]); 此处的dp[2]为本次循环的结果，而非上次循环的结果
            // 即应为使用dp[i-1][j],但却使用为了dp[i][j]
            // for (int j = capacity; j >= 1; j--) {
            //     if (j >= weight[i - 1]){
            //         dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
            //     }
            // }
            // 此处可以优化，去掉if，判断条件改为j >= weight[i - 1],因为放不下该物品的话，数组值不会因第i个物品而改变，因此直接用以前的就行
            for (int j = capacity; j >= weight[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
            }
            for (int k = 0; k < dp.length; k++) {
                System.out.print(dp[k] + " ");
            }
            System.out.println();
        }

        return dp[capacity];
    }
}
