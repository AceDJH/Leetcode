/**
 * @Author AceDJH
 * @Date 2021/3/9 14:36
 */
public class Offer5New {
    public static void main(String[] args) {
        System.out.println(new Solution5New().replaceSpace("  12 3 "));
    }
}

class Solution5New {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }
}
