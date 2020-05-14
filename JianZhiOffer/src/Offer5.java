/**
 * @Author AceDJH
 * @Date 2020/5/11 21:26
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Offer5 {
    public static void main(String[] args) {
        System.out.println(new Solution5().replaceSpace(""));
    }
}

/*利用Java工具
class Solution5 {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return String.valueOf(stringBuilder);
    }
}*/

class Solution5 {
    public String replaceSpace(String s) {
        int originalLength = s.length();
        if (originalLength <= 0){
            return s;
        }
        int newLength = 0;
        int numberOfBlank = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                ++numberOfBlank;
            }
        }
        newLength = originalLength + 2 * numberOfBlank;
        if (numberOfBlank == 0){
            return s;
        }
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        char[] str = new char[newLength];
        while (indexOfOriginal >= 0){
            if (s.charAt(indexOfOriginal) == ' '){
                str[indexOfNew--] = '0';
                str[indexOfNew--] = '2';
                str[indexOfNew--] = '%';
            }
            else {
                str[indexOfNew--] = s.charAt(indexOfOriginal);
            }
            indexOfOriginal--;
        }
        return String.valueOf(str);
    }
}