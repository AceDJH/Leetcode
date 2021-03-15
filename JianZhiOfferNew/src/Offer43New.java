/**
 * @Author AceDJH
 * @Date 2021/3/15 12:46
 */
public class Offer43New {
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0){
            if (cur == 0){
                res += high * digit;
            }else if (cur == 1){
                res += high * digit + low + 1;
            }else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            digit *= 10;
            cur = high % 10;
            high /= 10;
        }
        return res;
    }
}
