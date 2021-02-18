/**
 * @Author AceDJH
 * @Date 2021/2/14 13:08
 */
public class Offer16 {
    public static void main(String[] args) {
        System.out.println(1.00 == 1.000);
    }
}

class Solution16 {
    public double myPow(double x, int n) {
        boolean isPositive = n >= 0;
        if (x == 1){
            return 1;
        }
        long b = n;
        b = Math.abs(b);
        double res = 1;
        while (b > 0){
            if ((b & 1) == 1){
                res *= x;
            }
            b = b >> 1;
            x *= x;
        }
        return isPositive ? res : 1 / res;
    }
}