package xiaomi;

import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/9/8 7:38 下午
 * 最长公共子序列
 * 1A2C3D4E56
 * A1B2345C6D
 * 6
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(longest(s1, s2));
    }

    public static int longest(String s1, String s2){
        int[] dp = new int[s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            int pre = 0;
            for (int j = 1; j <= s2.length(); j++) {
                int cur = dp[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[j] = pre + 1;
                }else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = cur;
            }
        }
        return dp[s2.length()];
    }
}
