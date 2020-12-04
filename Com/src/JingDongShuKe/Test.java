package JingDongShuKe;

import java.util.Stack;

/**
 * @Author AceDJH
 * @Date 2020/11/14 13:58
 * 请用Java编程实现字符串倒序输出，如输入“I am Tom”,输出“Tom am I”。
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(reverseString(""));
    }

    // 使用split会更快
    public static String reverseString(String str){
        Stack stack = new Stack();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            if (str.charAt(i) == ' '){
                stack.push(stringBuilder);
                stringBuilder = new StringBuilder();
            }
        }
        stringBuilder.append(' ');
        stack.push(stringBuilder);
        StringBuilder stringBuilder1 = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder1.append(stack.pop());
        }
        return String.valueOf(stringBuilder1);
    }
}
