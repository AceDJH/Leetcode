/**
 * @Author AceDJH
 * @Date 2021/2/14 12:56
 */
public class Offer15 {
    public static void main(String[] args) {
        // System.out.println(4 >> 1);
        System.out.println(new Solution15().hammingWeight(00000000000000000000000000001011));
    }
}

class Solution15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count =  0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}