/**
 * @Author AceDJH
 * @Date 2020/2/15 15:30
 */
public class E_344_Reverse_String {
    public static void main(String[] args) {
        Solution344 solution = new Solution344();
        char[] chars = {'h', 'e', 'l', 'd', 'o'};
        solution.reverseString(chars);
    }
}

class Solution344 {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i <= j; i++, j--) {
            char a = s[i];
            s[i] = s[j];
            s[j] = a;
        }
        System.out.println(s);
    }
}
