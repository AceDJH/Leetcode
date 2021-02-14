/**
 * @Author AceDJH
 * @Date 2021/2/14 12:52
 */
public class Offer14_2 {

}

class Solution14_2 {
    public int cuttingRope(int n) {
        if (n < 4){
            return n - 1;
        }
        int timesOf3 = n / 3;
        int num = n - 3 * timesOf3;
        int timesOf2 = 0;
        if (num == 1){
            --timesOf3;
            timesOf2 = 2;
        }
        if (num == 2){
            timesOf2 = 1;
        }
        long res = 1;
        for (int i = 0; i < timesOf3; i++) {
            res = res * 3 % 1000000007;
        }
        return (int) (res * Math.pow(2, timesOf2) % 1000000007);
    }
}
