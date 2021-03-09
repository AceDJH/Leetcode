/**
 * @Author AceDJH
 * @Date 2021/3/9 15:24
 */
public class Offer10_1New {
}

class Solution10_1New {
    public int fib(int n) {
        if (n <= 1){
            return n;
        }
        long a = 0;
        long b = 1;
        long num = 0;
        for (int i = 0; i < n - 1; i++){
            num = (a + b) % 1000000007;
            a = b;
            b = num;
        }
        return (int) (num % 1000000007);
    }
}
