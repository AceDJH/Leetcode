/**
 * @Author AceDJH
 * @Date 2021/2/21 20:59
 */
public class Offer46 {
    public static void main(String[] args) {
        System.out.println(new Solution46().translateNum(12258));
    }
}

class Solution46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String substring = s.substring(i - 2, i);
            int parseInt = Integer.parseInt(substring);
            int c = b;
            if (parseInt >= 10 && parseInt <= 25){
                c = a + b;
            }
            a = b;
            b = c;
        }
        return b;
    }
}