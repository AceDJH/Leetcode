/**
 * @Author AceDJH
 * @Date 2021/3/10 15:58
 */
public class Offer15New {
}

class Solution15New {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            if ((n & 1) == 1){
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
