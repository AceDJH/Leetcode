/**
 * @Author AceDJH
 * @Date 2021/2/7 20:04
 */
public class Offer5 {
    public static void main(String[] args) {
        System.out.println(new Solution5().replaceSpace("  12 3 "));
    }
}

class Solution5 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            if (c == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}