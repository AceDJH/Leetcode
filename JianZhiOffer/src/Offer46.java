/**
 * @Author AceDJH
 * @Date 2020/12/22 10:17
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class Offer46 {
    public static void main(String[] args) {
        System.out.println(new Solution46().translateNum(16822));
    }
}

class Solution46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] count = new int[s.length()];
        count[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            String substring = s.substring(i - 1, i + 1);
            int parseInt = Integer.parseInt(substring);
            if (parseInt >= 10 && parseInt <= 25){
                if (i >= 2){
                    count[i] = count[i - 2] + count[i - 1];
                }else {
                    count[i] = 2;
                }
            }else {
                count[i] = count[i - 1];
            }
        }
        return count[s.length() - 1];
    }
}
