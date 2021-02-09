/**
 * @Author AceDJH
 * @Date 2021/2/9 10:27
 */
public class Offer10_1 {
    public static void main(String[] args) {
        System.out.println(new Solution10_1().fib(95));
    }
}

class Solution10_1 {
    public int fib(int n) {
        if (n <= 1){
            return n;
        }
        long one = 0;
        long two = 1;
        long sum = 0;
        for (int i = 2; i <= n; i++){
            sum = (one + two) % 1000000007;
            one = two;
            two = sum;
        }
        return (int) (sum % 1000000007);
    }
}