/**
 * @Author AceDJH
 * @Date 2021/2/14 10:39
 */
public class Offer14_1 {
    public static void main(String[] args) {
        System.out.println(new Solution14_1().cuttingRope(10));
    }
}

class Solution14_1 {
    public int cuttingRope(int n) {
        if(n <  2){
            return 0;
        }
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
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
