/**
 * @Author AceDJH
 * @Date 2021/3/10 16:02
 */
public class Offer16New {
}

class Solution16New {
    public double myPow(double x, int n) {
        boolean isFu = false;
        long b = n;
        if (b < 0){
            isFu = true;
            b = Math.abs(b);
        }
        double pow = 1;
        while (b != 0){
            if ((b & 1) != 0){
                pow *= x;
            }
            b = b >> 1;
            x *= x;
        }
        return isFu ? 1 / pow : pow;
    }
}
