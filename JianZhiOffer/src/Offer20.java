/**
 * @Author AceDJH
 * @Date 2020/8/10 20:54
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 *
 *
 */
public class Offer20 {
    public static void main(String[] args) {
        // System.out.println(new Solution20().isNumber("0 "));
        System.out.println(new Solution20().isNumber("e "));
    }
}

class Solution20 {
    private int index;
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        s = s.trim();
        index = 0;
        boolean numeric = scanInteger(s);
        if (index < s.length() && '.' == s.charAt(index)){
            index++;
            numeric = scanUnsignedInteger(s) || numeric;
        }
        if (index < s.length() && ('E' == s.charAt(index) || 'e' == s.charAt(index))){
            index++;
            numeric = scanInteger(s) && numeric;
        }
        return numeric && index == s.length();
    }

    public boolean scanInteger(String s){
        if (index < s.length() && ('+' == s.charAt(index) || '-' == s.charAt(index))) {
            index++;
        }
        return scanUnsignedInteger(s);
    }

    public boolean scanUnsignedInteger(String s){
        int before = index;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
            index++;
        }
        return index > before;
    }
}
