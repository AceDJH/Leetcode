/**
 * @Author AceDJH
 * @Date 2020/2/15 13:21
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class E_557_Reverse_Words_in_a_String_III {
    public static void main(String[] args) {
        String s = "lla";
        System.out.println(s.charAt(1));
        Solution solution = new Solution();
        String a = solution.reverseWords("ha kaka dwa");
        System.out.println(a);

    }
}
/*各种函数还有Java特性都忘记了，因此这样写
    1、自己写的
class Solution {
    public String reverseWords(String s) {
        char[] str = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            str[i] = s.charAt(i);
        }
        int m = 0 , n = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' '){
                n++;
            }else{
                for (int p = m , q = n;p <= q; p++, q--){
                    char a = str[p];
                    str[p] = str[q];
                    str[q] = a;
                }
                m = i + 1;
                n = i;
            }
            if (i == str.length - 1){
                for (int p = m , q = n;p <= q; p++, q--){
                    char a = str[p];
                    str[p] = str[q];
                    str[q] = a;
                }
            }
        }
        return String.valueOf(str);
    }
}*/

/*2、使用JAVA函数
*   String：适用于少量的字符串操作的情况
　　StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
　　StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况
* StringBuilder和StringBuffer的API相同
* 在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的
* 执行速度，在这方面运行速度快慢为：StringBuilder > StringBuffer > String
* */
class Solution{
    public String reverseWords(String s){
        String words[] = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(new StringBuilder(word).reverse().toString() + " ");
        }
        return stringBuilder.toString().trim();
    }
}


