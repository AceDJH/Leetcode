import java.util.Scanner;

/**
 * @author AceDJH
 * @date 2021/8/18 7:53 下午
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MAX = 1024;
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] v = new int[MAX];
        int[] w = new int[MAX];
        int[] s = new int[MAX];

        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            s[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int res = dp(n, m, v, w, s);
        System.out.println(res);
    }

    private static int dp(int n, int m, int[] v, int[] w, int[] s) {
        int[] f = new int[1024];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
                    f[j] = Math.max(f[j], f[j - k * v[i]] + k * w[i]);
                }
            }
        }
        return f[m];
    }
}
