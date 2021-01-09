/**
 * @Author AceDJH
 * @Date 2021/1/9 9:57
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Offer58_1 {
    public static void main(String[] args) {
        System.out.println(new Solution58_1Better().reverseWords("  hello world!  ") + ";");
    }
}

class Solution58_1 {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFirst = true;
        for (int i = strings.length - 1; i > 0; i--) {
            if (!"".equals(strings[i])){
                if (isFirst){
                    stringBuilder.append(strings[i]);
                    isFirst = false;
                }else {
                    stringBuilder.append(" ").append(strings[i]);
                }
            }
        }
        if (strings.length != 0 && !"".equals(strings[0])){
            if (strings.length == 1){
                stringBuilder.append(strings[0]);
            }else {
                stringBuilder.append(" ").append(strings[0]);
            }
        }
        return stringBuilder.toString();
    }
}

// 关键是trim方法删除空格就很好用，不过执行用时超过上面的方法
class Solution58_1Better {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if ("".equals(strings[i])){
                continue;
            }
            stringBuilder.append(strings[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}