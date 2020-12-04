package KuaiShou;

import java.util.Scanner;

/**
 * 小明最近在做病毒自动检测，他发现，在某些library 的代码段的二进制表示中，如果包含子串并且恰好有k个1，就有可能有潜在的病毒。library的二进制表示可能很大，并且子串可能很多，人工分析不可能，于是他想写个程序来先算算到底有多少个子串满足条件。如果子串内容相同，但是开始或者结束位置不一样，则被认为是不同的子串。
 * 注：子串一定是连续的。例如"010"有6个子串，分别是 "0, "1", "0", "01", "10", "010"
 * 思路：动态规划思路，当前状态依赖前k个状态并且需维护当前状态为后面服务，需要k+1空间，但是需要开辟k+2个空间，其中一个空间来消除掉之前状态的值。
 */
public class Virus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        int num = 0, len = s.length();
        int[] dp = new int[k + 2];
        long result = 0;
        dp[0] = 1;
        for (char c : s.toCharArray()) {
            if (c == '1') num++;
            if (num - k >= 0) result += dp[(num - k) % (k + 2)];
            dp[(num + 1) % (k + 2)] = 0;
            dp[num % (k + 2)]++;
        }
        System.out.println(result);
    }
}
