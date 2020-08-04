import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author AceDJH
 * @Date 2020/2/24 22:22
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class EW_204_Count_Primes {
    public static void main(String[] args) {
        System.out.println(new Solution204().countPrimes(499979));
    }
}

/*超出时间限制...（方法太笨拙了）
*单就这个笨拙的方法而言，还是写的冗余太大，完全可以抽出来一个函数
class Solution204 {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        int count = 1;
        if (n > 3)
            count++;
        for (int i = 5; i < n; i += 2) {
            boolean isPrime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                count++;
            }
        }
        return count;
    }
}*/
// 笨拙方法的优化
/*
class Solution204 {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        if (n == 3)
            return 1;
        int count = 1;
        for (int i = 3; i < n; i+=2) {
            if (isPrime(i))
                count++;
        }
        return count;
    }

    public boolean isPrime(int n){
        for (int i = 2; i * i <= n ; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}*/

// 方法优化细节很多，因此若是日后看不懂，https://leetcode-cn.com/problems/count-primes/solution/ru-he-gao-xiao-pan-ding-shai-xuan-su-shu-by-labula/
class Solution204 {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count++;
        }
        return count;
    }
}

