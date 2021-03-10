/**
 * @Author AceDJH
 * @Date 2021/3/10 17:02
 */
public class Offer20New {
    public static void main(String[] args) {
        System.out.println(new Solution20New().isNumber("0"));
    }
}

class Solution20New {
    int index = 0;
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        s = s.trim();
        char[] chars = s.toCharArray();
        boolean numeric = false;
        numeric = scanNumber(chars);
        if (index < chars.length && '.' == chars[index]){
            index++;
            numeric = scanUnsignedNumber(chars) || numeric;
        }
        if (index < chars.length && ('E' == chars[index] || 'e' == chars[index])){
            index++;
            numeric = numeric && scanNumber(chars);
        }
        return numeric && index == chars.length;
    }

    public boolean scanNumber(char[] chars){
        if (index < chars.length && (chars[index] == '+' || chars[index] == '-')){
            index++;
        }
        return scanUnsignedNumber(chars);
    }

    public boolean scanUnsignedNumber(char[] chars){
        int before = index;
        while (index < chars.length && chars[index] >= '0' && chars[index] <= '9'){
            index++;
        }
        return index > before;
    }
}
