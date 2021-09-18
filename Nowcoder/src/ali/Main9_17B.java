package ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/9/17 7:23 下午
 * 给出一个长度为n的数列，请计算这个数列中长度不超过k的严格递增子序列的个数
 * eg：
 * 输入：
 * 3 1
 * 1 2 3
 * 输出：3
 *
 * 输入：
 * 5 2
 * 1 2 3 4 2
 * 输出：12
 * 解释：单独一个的为5个，（1 2）（1 3）（1 4）（1 2）（2 3）（2 4）（3 4）
 * 5 + 7 = 12
 */
public class Main9_17B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
    }

    public static int getCount(int[] nums, int k){
        int len = nums.length;
        int[][] dp = new int[len + 1][k + 1];
        for (int i = 0; i < len; i++) {
            dp[i][1] = 1;
        }
        for (int i = 0; i < k; i++) {
            
        }
        return 0;
    }
}
