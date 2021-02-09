/**
 * @Author AceDJH
 * @Date 2021/2/9 10:40
 */
public class Offer10_2 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}

class Solution10_2 {
    public int numWays(int n) {
        if (n <= 1){
            return 1;
        }
        int one = 1;
        int two = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++){
            temp = (one + two) % 1000000007;
            one = two;
            two = temp;
        }
        return temp % 1000000007;
    }
}