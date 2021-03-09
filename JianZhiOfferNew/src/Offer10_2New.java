/**
 * @Author AceDJH
 * @Date 2021/3/9 15:31
 */
public class Offer10_2New {
}

class Solution10_2New {
    public int numWays(int n) {
        if (n <= 0){
            return 1;
        }
        if (n <= 3){
            return n;
        }
        long a = 1;
        long b = 2;
        long num = 0;
        for (int i = 0; i < n - 2; i++){
            num = (a + b) % 1000000007;
            a = b;
            b = num;
        }
        return (int)num;
    }
}

